# 🚀 Smart Debug Starter

A plug-and-play Spring Boot starter library that transforms messy stack traces into clean, structured, developer-friendly debug reports.

---

## 📌 Overview

Debugging Spring Boot applications often involves digging through long, noisy stack traces filled with framework internals.

**Smart Debug Starter** simplifies this by:

- Extracting the actual root cause  
- Highlighting user-level code (not framework noise)  
- Showing execution flow across layers (Controller → Service → Repository)  

---

## ✨ Features

- ✅ Automatic exception interception (no manual setup)  
- ✅ Clean root cause extraction  
- ✅ Intelligent stack trace filtering (removes Spring/Java noise)  
- ✅ Displays execution flow of user code  
- ✅ Shows exception chain (wrapped exceptions)  
- ✅ Provides developer-friendly suggestions (rule-based, extensible to AI)  
- ✅ Works seamlessly with existing Spring Boot logs  

---

## 🧾 Example Output

```
---------------------------------------------------------------------
                         SMART DEBUG REPORT
---------------------------------------------------------------------
[23:40:53] Root Cause: RuntimeException
[23:40:53] Message: Service layer failed
[23:40:53] Location: UserService.java:13

[23:40:53] Flow
          -> controller.TestController.test4(TestController.java:46)
          -> service.UserService.getUser(UserService.java:15)
          -> repo.UserRepo.getUserData(UserRepo.java:7)

[23:40:53] Exception Chain:
          RuntimeException → StringIndexOutOfBoundsException

[23:40:53] Suggestions:
          Check index bounds before accessing string.
---------------------------------------------------------------------
```

---

## 🏗 Architecture

```
src/main/java/com/vivek/smart_debug_starter
│
├── Analyzer # Core analysis logic (root cause, flow building, etc.)
├── Autoconfigure # Spring Boot auto-configuration
├── ConsoleFormat # Formats output into readable debug report
├── Filter # Removes framework/internal stack trace noise
├── Interceptor # Global exception interception (@ControllerAdvice)
├── Model # Data models used across the system
└── Suggestions # Rule-based suggestion engine
```


## Installation

### 1. Add dependency in pom.xml
```
<dependency>
  <groupId>io.github.vivan-1045</groupId>
  <artifactId>smart-debug-spring-boot-starter</artifactId>
  <version>1.0.0</version>
</dependency>
```
### 2. That’s it 🎉

   - No configuration required.
   - It auto-configures using Spring Boot’s @ControllerAdvice.

## 🔍 How It Works

### 1. Exception Interception
- Captures all runtime exceptions using a global handler

### 2. Root Cause Detection
- Extracts the most meaningful exception (not servlet/container noise)

### 3. Noise Filtering
Removes stack traces from:
- Spring Framework  
- Java internals  
- Servlet containers  

### 4. Execution Flow Tracking
Builds a readable call flow like:

  ```Controller → Service → Repository```


### 5. Suggestion Engine
- Provides basic debugging suggestions  
- Designed to integrate with RAG-based AI (coming soon)

## 🚧 Upcoming Features

- 🤖 AI-powered debugging assistant (RAG-based)  
- 🌐 StackOverflow + Reddit error learning integration  
- 🧠 Context-aware fix suggestions using LLM  

## Sample Use Case
```@GetMapping("/error")
public void test() {
    String s = "abc";
    System.out.println(s.charAt(10));
}
```

## ✅ Instead of Messy Logs, You Get

- ✔ Exact failure location  
- ✔ Clean execution path  
- ✔ Human-readable explanation  
- ✔ Original Spring Boot logs remain unchanged (report is appended at the end)  

---

## 🎯 Why This Project Matters

- ⏱ Saves debugging time  
- 🚀 Improves developer productivity  
- 🧹 Reduces noise in logs  
- 🎓 Helps beginners understand errors faster  
- 🤖 Scales to AI-assisted debugging systems

---

## 🤝 Contributing

Contributions, ideas, and feedback are welcome!  
If you'd like to improve this project:

1. Fork the repository  
2. Create a feature branch  
3. Submit a pull request  

---


