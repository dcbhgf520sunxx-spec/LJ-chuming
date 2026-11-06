import { n as E } from "../shared/runtime.js";
const L = { UN_HANDLE: { L: "未处理", K: "UN_HANDLE", V: 1, style: "border:1px solid rgb(0, 120, 252); background: #fff; color: rgb(0, 120, 252);" }, HANDLED: { L: "已处理", K: "HANDLED", V: 2, style: "background: #0078fc; color: #fff;" }, TAG: { L: "标记", K: "TAG", V: 4, style: "border:1px dashed rgb(0, 120, 252); background: #fff; color: rgb(0, 120, 252);" }, NOT_HANDLE: { L: "无需处理", K: "NOT_HANDLE", V: 8, style: "background: #66aefd; color: #fff;" }, CANCEL_HANDLE: { L: "取消变更", K: "CANCEL_HANDLE", V: 16, style: "background: #da0000; color: #fff;" } };
E(L);
const a = { NEW: { L: "新", K: "NEW", V: 1, C: "#0063d0" }, ADD: { L: "加", K: "ADD", V: 2, C: "#00ae11" }, EDIT: { L: "改", K: "EDIT", V: 4, C: "#ae4e00" }, REDUCE: { L: "减", K: "REDUCE", V: 8, C: "#e28a18" }, DEL: { L: "删", K: "DEL", V: 16, C: "#ff0000" }, KEEP: { L: "保持", K: "KEEP", V: 32, C: "#808080" } };
E(a);
const e = { EDIT: { L: "变更", K: "EDIT", V: 1, T: "warning" }, NEW: { L: "新增", K: "NEW", V: 2, T: "primary" } };
E(e);
const o = { KEEP: { L: "保持", K: "KEEP", V: 1 }, OTHER: { L: "其它", K: "OTHER", V: 2 }, ADD_LENGTH: { L: "加长", K: "ADD_LENGTH", V: 4 }, TRUNCATE: { L: "截短", K: "TRUNCATE", V: 8 }, PUNCH_HOLE: { L: "打孔", K: "PUNCH_HOLE", V: 16 } };
E(o);
export {
  e as a,
  o as b,
  a as c,
  L as d
};
