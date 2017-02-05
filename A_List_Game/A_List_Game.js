function score(input){
    var n = input;
    var factors = 0;
    var current = 2;
    for(var i=0; i*i <= input; i++){
        if(n%current == 0){
            n /= current;
            factors ++;
        }
        else{
            current ++;
        }
    }
    if(n>1){
        factors ++;
    }
    return factors;
}

print(score(readline()));
