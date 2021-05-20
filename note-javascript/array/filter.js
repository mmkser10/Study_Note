// 값의 길이가 6 이하인 모든 요소가 제거된 걸러진 배열
const words = ['spray', 'limit', 'elite', 'exuberant', 'destruction', 'present'];
const result_words = words.filter(word => word.length > 6);
console.log(result_words);

// 값이 10 이하인 모든 요소가 제거된 걸러진 배열
const numbers = [12, 5, 8, 130, 44];
const result_number = numbers.filter(number => number > 10);
console.log(result_number);

// 배열 내용을 조건에 따라 검색
const fruits = ['apple', 'banana', 'grapes', 'mango', 'orange'];
const filterItems = (query) => {
  return fruits.filter((el) =>
    el.toLowerCase().indexOf(query.toLowerCase()) > -1
  );
}
console.log(filterItems('ap'));
console.log(filterItems('an'));
