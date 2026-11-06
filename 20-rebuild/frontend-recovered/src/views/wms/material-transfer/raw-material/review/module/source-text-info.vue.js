import { computed as d } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as p } from "vue";
import { createTextVNode as i } from "vue";
import { toDisplayString as l } from "vue";
import { Fragment as w } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as S } from "vue";
import { withCtx as _ } from "vue";
import { createCommentVNode as j } from "vue";
import { ElTooltip as x } from "element-plus";
const N = { class: "project-ware-text" }, y = { __name: "source-text-info", props: { transferReceipt: { type: Object, default: () => ({}) } }, setup(f) {
  const c = f, m = d(() => {
    const r = JSON.parse(JSON.stringify(c.transferReceipt)), e = r.source;
    let o = "", s = [];
    return e && e.length > 0 && (e.forEach((t, b) => {
      let a = "";
      t && t.project ? a += t.project : a += "公共库", t.workshop && (a += `（${t.workshop.name}）`), s.push(a);
    }), s = Array.from(new Set(s)), o = s.join("　/　")), r.source = o, r;
  });
  return (r, e) => {
    const o = x;
    return n(), p("span", null, [i(l(m.value.source) + " ", 1), c.transferReceipt.boolBorrowReturnNotSelf ? (n(), p(w, { key: 0 }, [e[0] || (e[0] = u("span", { class: "borrow-direction-icon" }, "▶", -1)), e[1] || (e[1] = i("  ")), S(o, { content: "实际借用项目", placement: "top" }, { default: _(() => [u("span", N, l(c.transferReceipt.borrowProject), 1)]), _: 1 })], 64)) : j("", true)]);
  };
} };
export {
  y as default
};
