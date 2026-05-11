# FastTokenizer — Lightweight Source Code Analysis [v0.1.0]

**Deterministic source code tokenization for the FastJava ecosystem.**

[![Build](https://img.shields.io/github/actions/workflow/status/andrestubbe/FastTokenizer/maven.yml?branch=main)](https://github.com/andrestubbe/FastTokenizer/actions)
[![Java](https://img.shields.io/badge/Java-17+-blue.svg)](https://www.java.com)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![JitPack](https://jitpack.io/v/andrestubbe/FastTokenizer.svg)](https://jitpack.io/#andrestubbe/FastTokenizer)

FastTokenizer is a standalone module designed to break down source code into structural tokens (Keywords, Identifiers, Comments, etc.) with zero dependencies and maximum performance.

## Key Features
- **🚀 Zero Dependencies** — Minimal footprint, high speed.
- **⚡ Deterministic Scanner** — Predictable O(n) performance.
- **📦 Off-heap Ready** — Uses `CharSequence` to support zero-copy buffers.
- **🎨 Theme-Agnostic** — Separates structure from styling.

## Installation

### Maven (JitPack)
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.andrestubbe</groupId>
        <artifactId>fasttokenizer</artifactId>
        <version>0.1.0</version>
    </dependency>
</dependencies>
```

## Quick Start

```java
import fasttokenizer.CodeTokenizer;
import fasttokenizer.SimpleJavaTokenizer;
import fasttokenizer.Token;

public class Demo {
    public static void main(String[] args) {
        CodeTokenizer tokenizer = new SimpleJavaTokenizer();
        String code = "public class Test {}";
        
        for (Token token : tokenizer.tokenize(code)) {
            System.out.println(token.getType() + ": " + token.getText());
        }
    }
}
```

## Relationship with FastJava
FastTokenizer is a structural layer used by:
- **FastPreview**: To identify token positions for rasterization.
- **FastTheme**: To map tokens to visual styles and colors.

## License
MIT
