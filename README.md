# Arrays vs Lists in Kotlin

This repository demonstrates the differences between arrays and lists in Kotlin, when to use each, and their various types.

## Overview

Kotlin provides two main ways to store collections of elements:
- **Arrays** - Fixed-size collections with mutable elements
- **Lists** - Dynamic collections that can be mutable or immutable

## Arrays

### What are Arrays?
Arrays in Kotlin are fixed-size collections that store elements of the same type. Once created, the size cannot be changed.

### Array Types

1. **Array<T>** - Generic array type
2. **Primitive Arrays** - Specialized arrays for primitive types:
   - `IntArray` - Array of integers
   - `DoubleArray` - Array of doubles
   - `BooleanArray` - Array of booleans
   - `CharArray` - Array of characters
   - `ByteArray` - Array of bytes
   - `ShortArray` - Array of shorts
   - `LongArray` - Array of longs
   - `FloatArray` - Array of floats

### When to Use Arrays

✅ **Use Arrays when:**
- You know the exact size at compile time
- You need maximum performance (especially with primitive types)
- Working with low-level operations or APIs that require arrays
- Memory efficiency is critical
- Interoperating with Java code that expects arrays

### Array Examples

```kotlin
// Creating arrays
val numbers = arrayOf(1, 2, 3, 4, 5)
val intArray = intArrayOf(1, 2, 3, 4, 5) // Primitive array
val emptyArray = arrayOfNulls<String>(5) // Array of nulls

// Accessing elements
val firstElement = numbers[0]
numbers[0] = 10 // Mutable

// Array size is fixed
println(numbers.size) // Always 5
```

## Lists

### What are Lists?
Lists in Kotlin are collections that can be either mutable or immutable. They can grow and shrink in size.

### List Types

1. **List<T>** - Immutable list (read-only)
2. **MutableList<T>** - Mutable list (can add/remove elements)
3. **ArrayList<T>** - Mutable list implementation

### When to Use Lists

✅ **Use Lists when:**
- You need to add or remove elements dynamically
- The size is unknown at compile time
- You want immutable collections for better safety
- Working with functional programming patterns
- You need more collection operations (filter, map, etc.)

### List Examples

```kotlin
// Creating lists
val immutableList = listOf(1, 2, 3, 4, 5)
val mutableList = mutableListOf(1, 2, 3, 4, 5)
val arrayList = arrayListOf(1, 2, 3, 4, 5)

// Adding elements
mutableList.add(6)
mutableList.addAll(listOf(7, 8, 9))

// Removing elements
mutableList.removeAt(0)
mutableList.remove(5)

// Immutable list operations
val doubled = immutableList.map { it * 2 }
val filtered = immutableList.filter { it % 2 == 0 }
```

## Key Differences

| Feature | Arrays | Lists |
|---------|--------|-------|
| **Size** | Fixed at creation | Dynamic (mutable) or fixed (immutable) |
| **Mutability** | Elements are mutable | Can be mutable or immutable |
| **Performance** | Faster (especially primitives) | Slightly slower due to overhead |
| **Memory** | More memory efficient | More memory overhead |
| **Operations** | Basic indexing | Rich collection operations |
| **Null Safety** | Can contain nulls | Type-safe by default |

## Performance Considerations

### Arrays
- **Pros**: Better performance, especially with primitive types
- **Cons**: Fixed size, limited operations
- **Best for**: Performance-critical code, known sizes

### Lists
- **Pros**: Dynamic size, rich operations, type safety
- **Cons**: Slight performance overhead
- **Best for**: Most general-purpose use cases

## Memory Usage

```kotlin
// Arrays - more memory efficient
val intArray = IntArray(1000) // 1000 * 4 bytes = 4KB

// Lists - more memory overhead
val intList = MutableList(1000) { 0 } // Additional object overhead
```

## Common Use Cases

### Use Arrays for:
- Game development (positions, scores)
- Mathematical computations
- Image processing
- Audio/video data
- Interfacing with native code

### Use Lists for:
- Data processing pipelines
- User interface collections
- API responses
- Configuration data
- Most business logic

## Best Practices

1. **Prefer Lists** for most use cases due to their flexibility
2. **Use Arrays** only when performance is critical or size is known
3. **Use Immutable Lists** when data shouldn't change
4. **Use Primitive Arrays** for large collections of primitive types
5. **Consider ArrayList** when you need both array-like access and list operations

## Conclusion

- **Arrays**: Use when you need maximum performance and know the size upfront
- **Lists**: Use for most general-purpose collections due to flexibility and safety
- **Choose based on your specific requirements**: performance vs. flexibility

Remember: In most cases, the performance difference is negligible, so prefer the more flexible and safer option (Lists) unless you have a specific performance requirement.
