# Infinite Power for Gregtech6

### Powerful Dynamos added

## Goal For Development

### Cooler

* Laval Nozzle, use GT6 SU to produce CU
* Air Conditioning Compressor, use KU/RU to produce CU

## Learn GT6 Structure

### Loader: how to add MultiTileEntity Machine

* `gregtech/loaders/b/Loader_MultiTileEntities` is the loader
* `gregtech/tileentity/energy/converters/MultiTileEntityDynamoElectric` is super class
* `MultiTileEntityBlock` -> `MultiTileEntity` -> NBT register
