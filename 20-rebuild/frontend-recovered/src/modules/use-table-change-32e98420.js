import { i } from "../shared/runtime.js";
function h({ fieldMap: e, columnsPropsChartMap: a }) {
  let r;
  return i(a) ? r = (t) => c(t, e, a) : r = (t) => o(t, e), { changedCellMask: r };
}
function o({ row: e, column: a }, r) {
  let t = false;
  const s = r.get(a.property);
  return s && (t = e[a.property] !== e[s]), t ? "mask-td" : "";
}
function c({ row: e, column: a }, r, t) {
  let s = false, n = t.get(a.property);
  Array.isArray(n) || (n = [n]);
  for (const f of n) {
    const l = r.get(f);
    if (l && (s = e[f] !== e[l]), s) break;
  }
  return s ? "mask-td" : "";
}
export {
  h as u
};
