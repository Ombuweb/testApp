import { ItemsLoading, Observable, ObservableArray,  } from '@nativescript/core'
export class HelloWorldModel extends Observable {

  constructor() {
    super()
  }
onTap() {

  var obsArray = new ObservableArray([1, 2, 3]);
var item = obsArray.getItem(1); // Get last item
obsArray.setItem(-1, item + 1); // Set new last item
console.log("OArray test",item)
  }

}
