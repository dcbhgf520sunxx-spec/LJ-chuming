import { L as l, P as m, a as r, b as T, M as A, c as S, d as B, e as $ } from "./constant_2-1ad5d80f.js";
import { bm as i, bk as f } from "../shared/runtime.js";
function M({ productType: t, labelType: e, labelData: E }) {
  const { printConfig: _ } = E;
  _.productType = t;
  let L, s;
  switch (_.labelSize) {
    case i.ONE.V:
      L = l, s = m;
      break;
    case i.TWO.V:
      L = r, s = T;
      break;
    default:
      L = l, s = m;
      break;
  }
  const a = L[t][e]({ ...E }), { style: c, fClass: n, qrPosition: o } = s[t][e];
  return { showHtml: `
    <div class="${n}">
      ${a}
    </div>
    ${c}
  `, qrPosition: o };
}
function P({ productType: t, labelType: e, labelData: E }) {
  const { printConfig: _ } = E;
  _.productType = t;
  let L, s;
  switch (_.labelSize) {
    case i.ONE.V:
      L = l, s = A;
      break;
    case i.TWO.V:
      L = r, s = S;
      break;
    default:
      L = l, s = A;
      break;
  }
  const a = L[t][e]({ ...E }), { style: c, fClass: n } = s[t][e];
  return `
    <div class="${n}">
     ${a}
    </div>
    ${c}
  `;
}
function I({ productType: t, labelType: e, component: E, manufacturerName: _, printConfig: L }) {
  L.productType = t;
  let s, a;
  switch (L.labelSize) {
    case i.ONE.V:
      s = l, a = B;
      break;
    case i.TWO.V:
      s = r, a = $;
      break;
    default:
      s = l, a = B;
      break;
  }
  const c = s[t][e]({ component: E, manufacturerName: _, printConfig: L }), { style: n, fClass: o } = a[t][e], b = `
    <div class="${o}">
      ${c}
    </div>`;
  return f(n, b);
}
export {
  M as a,
  P as b,
  I as g
};
