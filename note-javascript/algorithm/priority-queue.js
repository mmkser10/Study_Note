class PriorityQueue {
  constructor() {
      this.memory = [];
      this.length = 0;
  }
  push(newItem) {
      this.length++;
      let isAdded = false;
      for(let i = 0 ; i < this.memory.length ; ++i){
          if(this.memory[i].weight > newItem.weight){
              this.memory.splice(i, 0, newItem);
              isAdded = true;
              break;
          } 
      }        
      if(!isAdded) this.memory.push(newItem);
  }
  pop() {
      this.length--;
      return this.memory.shift();
  }
}
