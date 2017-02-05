var dict = {
    'A':'@',
    'B':'8',
    'C':'(',
    'D':'|)',
    'E':'3',
    'F':'#',
    'G':'6',
    'H':'[-]',
    'I':'|',
    'J':'_|',
    'K':'|<',
    'L':'1',
    'M':'[]\\/[]',
    'N':'[]\\[]',
    'O':'0',
    'P':'|D',
    'Q':'(,)',
    'R':'|Z',
    'S':'$',
    'T':"']['",
    'U':'|_|',
    'V':'\\/',
    'W':'\\/\\/',
    'X':'}{',
    'Y':'`/',
    'Z':'2'
}

var input = readline();
input = input.toUpperCase();
var arr = input.split('');
for(var i=0; i<arr.length; i++){
    if(dict.hasOwnProperty(arr[i])){
        arr[i] = dict[arr[i]];
    }
}

arr = arr.join('');
print(arr);