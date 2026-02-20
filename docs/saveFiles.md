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
3 Bytes: GWC (Magic Bytes)

1 Byte: Version

1 Byte: U+0017 (End of block)
```

### History Block

Repeat for every line

```
1 Byte: Charachter ID

    For Decimals Only:

    4 Bytes: scale (Java int)

    4 Bytes: number of bytes in unscaled value

    X Bytes: Unscaled Value (from BigInteger.toByteArray)

1 Byte: U+2028 (Line seperator)
```

Every two lines are paired as the input and output.

Final:

```
1 Byte: U+0017 (End of block)
```