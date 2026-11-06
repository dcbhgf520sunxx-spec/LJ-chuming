import { bl as d, bg as m, z6 as g, bk as E, be as f, bf as h, i as w } from "../shared/runtime.js";
let e;
const S = 1, p = 1e3, T = 120;
async function v({ material: t, copies: i = 1, printMode: r = m.QUEUE.V } = {}) {
  switch (t.basicClass) {
    case d.STEEL_PLATE.V:
      return await P({ material: t, copies: i, printMode: r });
    case d.SECTION_STEEL.V:
      return await I({ material: t, copies: i, printMode: r });
    case d.STEEL_COIL.V:
      return await L({ material: t, copies: i, printMode: r });
    default:
      return false;
  }
}
async function P({ material: t, copies: i = 1, printMode: r = m.QUEUE.V } = {}) {
  let o = false;
  try {
    const s = t.projectShortName || "公共库", n = `${t.specification} * ${g(t)}`, l = `
    <div class="material-info">
      <div class="first-line ellipsis-text ${c(s)}">
        ${s}
      </div>
      <div class="second-line ellipsis-text ${c(n)}">
        ${n}
      </div>
    </div>
    `, a = E(_, l);
    e = await f(), e.SET_PRINT_PAGESIZE(S, p, T, "1"), e.ADD_PRINT_HTM(0, 0, "100%", "100%", a), e.ADD_PRINT_BARCODE("1mm", "72mm", "28mm", "10mm", "128C", t.barcode), e.SET_PRINT_COPIES(i), o = await h(r);
  } catch (s) {
    throw new Error(s);
  }
  return o;
}
async function I({ material: t, copies: i = 1, printMode: r = m.QUEUE.V } = {}) {
  let o = false;
  try {
    const s = t.projectShortName || "公共库", n = `${t.length} * ${t.specification}`, l = `
    <div class="material-info">
      <div class="first-line ellipsis-text ${c(s)}">
        ${s}
      </div>
      <div class="second-line ellipsis-text ${c(n)}">
        ${n}
      </div>
    </div>
    `, a = E(_, l);
    e = await f(), e.SET_PRINT_PAGESIZE(S, p, T, "1"), e.ADD_PRINT_HTM(0, 0, "100%", "100%", a), e.ADD_PRINT_BARCODE("1mm", "72mm", "28mm", "10mm", "128C", t.barcode), e.SET_PRINT_COPIES(i), o = await h(r);
  } catch (s) {
    throw new Error(s);
  }
  return o;
}
async function L({ material: t, copies: i = 1, printMode: r = m.QUEUE.V, emptyText: o = "-" } = {}) {
  let s = false;
  try {
    const n = t.projectShortName || "公共库", l = `${g(t)}${w(t.color) && t.color !== "-" ? " * " + t.color : ""}${w(t.brand) && t.brand !== "-" ? " * " + t.brand : ""}`, a = `
    <div class="material-info">
      <div class="first-line ellipsis-text ${c(n)}">
        ${n}
      </div>
      <div class="second-line ellipsis-text ${c(l)}">
        ${l}
      </div>
    </div>
    `, u = E(_, a);
    e = await f(), e.SET_PRINT_PAGESIZE(S, p, T, "1"), e.ADD_PRINT_HTM(0, 0, "100%", "100%", u), e.ADD_PRINT_BARCODE("1mm", "72mm", "28mm", "10mm", "128C", t.barcode), e.SET_PRINT_COPIES(i), s = await h(r);
  } catch (n) {
    throw new Error(n);
  }
  return s;
}
function c(t) {
  const i = ["large-size", "middle-size", "small-size"];
  return t.length < 15 && t.length > 0 ? i[0] : t.length < 19 ? i[1] : i[3];
}
const _ = `
<style type="text/css">
  body {
    margin:0;
    padding:0;
    font-size:14pt;
    font-family:'SimSun, Microsoft Yahei';
  }
  .material-info {
    margin-left: 2mm;
    width: 71mm;
    height: 12mm;
    font-weight: bold;
  }
.first-line {
    height: 6mm;
    line-height: 6.5mm;
    width: inherit;
  }
  .second-line {
    height: 6mm;
    line-height: 5.5mm;
    width: inherit;
  }
  .ellipsis-text {
    vertical-align: middle;
    overflow : hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
  .large-size {
    font-size:14pt;
  }
  .middle-size {
    font-size:11pt;
  }
  .small-size {
    font-size:9pt;
  }
</style>
`;
export {
  v as p
};
