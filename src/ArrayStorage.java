/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i <= storage.length - 1; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i <= storage.length - 1; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {

        if (uuid.matches(".*\\d+")) {
            for (int i = 0; i <= storage.length - 1; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    return storage[i];
                }
            }
        }

        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i <= storage.length - 1; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                break;
            }
        }

        for (int i = 0; i <= storage.length - 2; i++) {
            if (storage[i] == null && storage[i + 1] != null) {
                storage[i] = storage[i + 1];
                storage[i + 1] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int countResume = 0;

        for (int i = 0; i <= storage.length - 1; i++) {
            if (storage[i] != null) {
                countResume++;
            }
        }

        Resume[] onlyResumes = new Resume[countResume];

        for (int i = 0; i <= storage.length - 1; i++) {
            if (storage[i] != null) {
                onlyResumes[i] = storage[i];
            }
        }

        return onlyResumes;
    }

    int size() {
        int size = 0;

        for (int i = 0; i <= storage.length - 1; i++) {
            if (storage[i] != null) {
                size++;
            }
        }

        return size;
    }
}
