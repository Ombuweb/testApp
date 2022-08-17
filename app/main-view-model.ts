import { ActionBar, Application, Button, CoercibleProperty, Color, CoreTypes, CssProperty, Dialogs, Frame, InheritedCssProperty, isIOS, ItemsLoading, Length, Observable, ObservableArray, PercentLength, Property, SegmentedBar, ShorthandProperty, Style, TextBase, TextField, Utils, View, ViewBase, zeroLength, } from '@nativescript/core'
import { SelectedIndexChangedEventData } from '@nativescript/core/ui/segmented-bar';
export class HelloWorldModel extends Observable {
  private inventoryVM= new com.ombuweb.sirpda.InventoryViewModel(Utils.android.getApplicationContext())
  public invId = 1;
  constructor( )
   {
     
    super()
    this.inventoryVM.getAllInventories().observe(
     Frame.topmost().android.currentActivity,
      new androidx.lifecycle.Observer<
        java.util.List<com.ombuweb.sirpda.Inventory>
      >({
        onChanged(inventories: java.util.List<com.ombuweb.sirpda.Inventory>) {
          const wdrs = [];
          if(inventories.size()) console.log(inventories.get(0))
          /*_this.words = [...Array(words.size()).keys()].map((i) => {
            const word: com.ombuweb.roomwordssample.Word = words.get(i);
            const wordStr: string = word.getWord();
            
            return wordStr;
          });*/
        },
      })
    );

  }
  onTap() {
   
  }

  insertInv(){
    const frame = new Frame();
    const fecha = new java.util.Date();
    const hora = new  java.lang.Long(fecha.getTime());
    const invId = new java.lang.Long(3)
    const units = new java.lang.Integer(20);
    const price = new java.lang.Double(23.89)
    const prevUnits = new java.lang.Integer(50);
    const inv = new com.ombuweb.sirpda.Inventory(fecha,hora,"My Ware", "DEsc","Nandee")
    
const prodVM = new com.ombuweb.sirpda.ProductViewModel(Utils.android.getApplication())
try {
 const inLong = this.inventoryVM.insert(inv)
 const product = new com.ombuweb.sirpda.Product(inLong.get(), "12384", "lote",
      units, price, prevUnits, "code1", null);
const product2 = new com.ombuweb.sirpda.Product(inLong.get(), "12385", "lote",
      units, price, prevUnits, "code1", null);
      const product3 = new com.ombuweb.sirpda.Product(inLong.get(), "12386", "lote",
      units, price, prevUnits, "code1", null);
      const products = new java.util.ArrayList();
      products.add(product);
      products.add(product2);
      products.add(product3);
  //prodVM.insert(product);

  prodVM.insertProducts(products)

} catch (error) {
  console.error(error)
}
  }
  deleteInv(){
    try {
      this.inventoryVM.deleteInventory(new java.lang.Integer(this.invId))

    } catch (error) {
      console.error(error)
    }
  }
}

