# GWC-84 Java Save Files

## Save Data

This file, SaveData.conf, is placed in the main directory. It contains the data to find save files.

### Structure

Data is stored with a piece of data per line:

```

normal save path

default save to load

6 saveSixFilePath

5 saveFiveFilePath

...

1 saveFileOnePath
```

## Save Files

### Structure

#### Header

```
6 Bytes: G84 (Magic Bytes, using Java char)

1 Byte: Version

2 Byte: U+0017 (End of block, using Java char)
```

### History Block

```
4 Bytes: Number of groups
```

Repeat for every line

```
4 Bytes Number of MathObjects in Line
```

Repeat for every MathObject

```
1 Byte: Charachter ID

    For Decimals Only:

    4 Bytes: scale (Java int)

    4 Bytes: number of bytes in unscaled value

    X Bytes: Unscaled Value (from BigInteger.toByteArray)

2 Bytes: U+2028 (Line seperator, using Java char)
```

Every two lines are paired as the input and output.

Final:

```
2 Bytes: U+0017 (End of block, using Java char)
```