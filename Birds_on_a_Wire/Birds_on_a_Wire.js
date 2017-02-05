var lineone = readline()
lineone = lineone.split(' ');
var birds = 0;
var dist = parseInt(lineone[1]);

var min = 6;
var max = parseInt(lineone[0]) - 6;

var pos = [];
for(var i = 0; i < parseInt(lineone[2]); i++) {
    pos[i] = parseInt(readline());
}
pos.sort(function(a,b){
    return a-b;
});

if(pos[0] - min >= dist || pos[0] == undefined){
    pos.unshift(min);
    birds ++;
}
if(max - pos[pos.length-1] >= dist){
    pos.push(max);
    birds ++;
}

for(var i = 0; i < pos.length - 1; i++){
    if(pos[i+1] - pos[i] >= 2 * dist){
        birds += Math.floor(((pos[i+1] - pos[i]) - dist) / dist); 
    }
}


print(birds);