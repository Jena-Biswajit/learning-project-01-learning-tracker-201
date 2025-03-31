### Linux Commands Guide

### 1. `ls` - List Files in a Directory
Lists files and directories in the current location.
```bash
ls -l
```
Shows files with details (permissions, size, etc.).

To list hidden files:
```bash
ls -la
```

### 2. `cd` - Change Directory
Moves between directories.
```bash
cd /usr/local/bin
```
Moves to `/usr/local/bin`.

To go back to the home directory:
```bash
cd ~
```

### 3. `cat` - View File Contents
Displays file content.
```bash
cat file.txt
```
To concatenate multiple files:
```bash
cat file1.txt file2.txt > merged.txt
```

### 4. `cp` - Copy Files
Copies a file from one location to another.
```bash
cp file.txt /home/user/Documents/
```
To copy directories recursively:
```bash
cp -r dir1/ dir2/
```

### 5. `mv` - Move or Rename Files
Moves or renames files.
```bash
mv oldname.txt newname.txt
```
To move a file to another directory:
```bash
mv file.txt /home/user/Documents/
```

### 6. `grep` - Search for Patterns in Files
Searches for a word or pattern.
```bash
grep "error" logfile.txt
```
Finds lines containing `"error"` in `logfile.txt`.

To search recursively in all files of a directory:
```bash
grep -r "error" /var/logs/
```

### 7. `tail` - View Last Lines of a File
Displays the last 10 lines of a file.
```bash
tail -10 logfile.txt
```
To view logs in real time:
```bash
tail -f /var/log/syslog
```

### 8. Checking Processes on a Specific Port (e.g., 8080)
To check which process is using **port 8080**:
```bash
lsof -i :8080
```
Another way to check:
```bash
netstat -tulnp | grep 8080
```
- `-t`: TCP connections
- `-u`: UDP connections
- `-l`: Listening ports
- `-n`: Show numerical addresses
- `-p`: Show process ID

### 9. Killing a Process Using PID
Find the PID of a process:
```bash
ps aux | grep java
```
Kill a process using its PID:
```bash
kill -9 <PID>
```
Example:
```bash
kill -9 1234
```
Terminates the process with PID `1234`.

### **Kill a Process by Name**
- **Kill a process by name (e.g., `firefox`):**
  ```sh
  pkill firefox
  ```
- **Force kill all instances of a process:**
  ```sh
  pkill -9 chrome
  ```

### ** Kill Processes Running on a Specific Port**
- **Find processes using port 8080:**
  ```sh
  lsof -i :8080
  ```
- **Kill the process using port 8080:**
  ```sh
  kill -9 $(lsof -t -i :8080)
  ```

# **️ File & Process Deletion Commands in Linux**

---

## **2️ File & Directory Deletion**

### **Delete a File**
- **Delete a single file:**
  ```sh
  rm filename.txt
  ```
- **Delete multiple files:**
  ```sh
  rm file1.txt file2.txt file3.txt
  ```
- **Force delete a file without confirmation:**
  ```sh
  rm -f important.log
  ```

### **Delete a Directory**
- **Delete an empty directory:**
  ```sh
  rmdir emptydir
  ```
- **Delete a non-empty directory and all its contents:**
  ```sh
  rm -r mydirectory
  ```
- **Force delete a directory without confirmation:**
  ```sh
  rm -rf mydirectory
  ```

### **Delete Specific File Types**
- **Delete all `.log` files in the current directory:**
  ```sh
  rm *.log
  ```
- **Delete all `.tmp` files in `/var/tmp/` directory:**
  ```sh
  rm /var/tmp/*.tmp
  ```

---


