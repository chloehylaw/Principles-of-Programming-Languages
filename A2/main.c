#include <stdio.h>
#include <stdlib.h>

typedef enum { ATOM, LIST } eltype;
typedef char atom;
struct _listnode;
typedef struct {
    eltype type;
    union {
        atom a;
        struct _listnode* l;
    };
} element;
typedef struct _listnode {
    element el;
    struct _listnode* next;
} * list;
const element NIL = { .type=LIST, .l=NULL };

// 1. element aasel(atom a); AKA atom as element, returns an element whose content is set to atom a
element aasel(atom a){
    element content;
    content.type = ATOM;
    content.a = a;
    return content;
}

// 2. element lasel(list l); AKA list as element, returns an element whose content is set to the list, pointed by l.
element lasel(list l){
    element content;
    content.type = LIST;
    content.l = l;
    return content;
}

// 3. list cons(element e, list l); that creates a new list whose car and cdr are the element e and the list l.
// While the memory for the newly created list is to be allocated dynamically.
list cons(element e, list l){
    list elements = (list) malloc(sizeof(struct _listnode));
    elements -> el = e;
    elements -> next = l;
    return elements;
}

// 4. list append(list l1, list l2); that creates a new list whose elements are shallow copies of elements in l1 and l2, appended.
list append(list l1, list l2){
    list newList = NULL;
    list temp = l1;
    while(temp != NULL){
        list temp2 = (list)malloc(sizeof(struct _listnode));
        list pointer;
        temp2 -> el = temp -> el;
        temp2 -> next = NULL;

        if(newList == NULL){
            newList = temp2;
        }else{
            pointer = newList;
            while(pointer -> next != NULL){
                pointer = pointer -> next;
            }
            pointer -> next = temp2;
        }
        temp = temp -> next;
    }
    list temp3 = l2;
    while(temp3 != NULL){
        list temp4 = (list)malloc(sizeof(struct _listnode));
        list pointer2;
        temp4 -> el = temp3 -> el;
        temp4 -> next = NULL;

        if(newList == NULL){
            newList = temp4;
        }else{
            pointer2 = newList;
            while(pointer2 -> next != NULL){
                pointer2 = pointer2 -> next;
            }
            pointer2 -> next = temp3;
        }
        temp3 = temp3 -> next;
    }
    return newList;
}

// 5. element car(element e); that returns head of the list, represented by e; returns NIL, if e is not a list.
element car(element e){
    if(e.type != LIST){
        return NIL;
    }
    return e.l -> el;
}

// 6. list cdr(element e); that returns tail of the list, represented by e.
list cdr(element e){
    if(e.type != LIST || e.l == NULL){
        return NULL;
    }
    return e.l -> next;
}

// 7. list cddr(element e); that similarly returns the cddr of the list, represented by e.
// cddr is the composition of two cdr functions
// make (cdr(cdr(e))
list cddr(element e){
    return cdr(lasel(cdr(e)));
}

// 8. void free(list l); that frees all the memory previously allocated by the whole list (including all its elements and its inner lists)
void freee(list l){
    list temp = l;
    while(temp != NULL){
        if(temp -> el.type == LIST){
            free(temp -> el.l);
        }
        list temp2 = temp -> next;
        free((void*)temp);
        temp = temp2;
    }
}

//9. void print(element e); that prints the content of the element e. If e is an atom, it prints the char symbol
// enclosed in spaces, and if e it is a list, it (recursively) prints the elements of the list enclosed in
// parentheses (`(` and `)'). If e is NIL, the word "NIL" is printed (see the following example).
void print(element e){
    if(e.type == LIST && e.l == NULL){
        printf("DO NOT EXIST!");
        return;
    }
    if(e.type == ATOM){
        printf("%c", e.a);
    }else{
        list this = e.l;
        printf("(");
        while(this != NULL){
            print(this -> el);
            this = this -> next;
        }
        printf(")");
    }
}

int main() {
        return 0;
    }

