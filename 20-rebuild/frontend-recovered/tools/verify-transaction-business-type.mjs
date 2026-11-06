import assert from 'node:assert/strict';
import fs from 'node:fs/promises';
import vm from 'node:vm';
import { parse } from '@babel/parser';
const segment = async name => fs.readFile(new URL('../src/shared/segments/' + name + '.fragment.js', import.meta.url), 'utf8');
const declarations = source => parse(source, { sourceType: 'module' }).program.body.flatMap(node => node.type === 'VariableDeclaration' ? node.declarations : []);
const constants = await segment('002'), crm = await segment('031'), contract = await segment('005'), templates = await segment('073');
const values = {};
for (const [source, names] of [[constants, ['Gm', 'xi']], [crm, ['Zc']]])
  for (const declaration of declarations(source).filter(node => names.includes(node.id.name)))
    values[declaration.id.name] = vm.runInNewContext('(' + source.slice(declaration.init.start, declaration.init.end) + ')');
function enumModule(source, symbol) {
  const declaration = declarations(source).find(node => node.id.name === symbol);
  assert.equal(declaration.init.type, 'ObjectExpression');
  return Object.fromEntries(declaration.init.properties.filter(property => property.value.type === 'Identifier' && Object.hasOwn(values, property.value.name))
    .map(property => [property.key.name, values[property.value.name]]));
}
const registry = Object.assign({}, enumModule(contract, 'xA'), enumModule(crm, 'IP'));
const blocks = [];
function walk(node) {
  if (!node || typeof node !== 'object') return;
  if (node.type === 'ObjectExpression' && node.properties.some(property => property.key?.name === 'type' && property.value?.value === 'transactionRecord')) blocks.push(node);
  for (const [key, value] of Object.entries(node)) if (key !== 'loc') {
    if (Array.isArray(value)) value.forEach(walk); else if (value && typeof value === 'object') walk(value);
  }
}
walk(parse(templates, { sourceType: 'module' }).program);
assert.equal(blocks.length, 1);
let name;
walkField(blocks[0]);
function walkField(node) {
  if (!node || typeof node !== 'object') return;
  if (node.type === 'ObjectExpression' && node.properties.some(property => property.key?.name === 'key' && property.value?.value === 'businessType')) {
    const format = node.properties.find(property => property.key?.name === 'format').value;
    name = format.properties.find(property => property.key?.name === 'enum').value.value;
  }
  for (const value of Object.values(node)) if (Array.isArray(value)) value.forEach(walkField); else if (value && typeof value === 'object') walkField(value);
}
assert.ok(name && registry[name], 'Transaction template enum must resolve after CRM registration');
const label = (name, value) => Object.values(registry[name]).find(item => item.V === value)?.L;
for (const [value, expected] of [[1, '加工承揽'], [2, '项目承包'], [4, '安装合同']]) assert.equal(label(name, value), expected, 'Transaction business type ' + value);
assert.equal(label('businessTypeEnum', 1), '直营', 'CRM type mapping stays independently correct');
assert.equal(label('businessTypeEnum', 2), '非直营');
console.log('Transaction business types: three contract labels and two CRM labels passed');
