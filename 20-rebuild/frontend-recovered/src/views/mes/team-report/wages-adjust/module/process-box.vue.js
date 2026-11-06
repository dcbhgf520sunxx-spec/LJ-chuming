import { inject as p } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as a } from "vue";
import { Fragment as i } from "vue";
import { renderList as g } from "vue";
import { unref as o } from "vue";
import { createBlock as y } from "vue";
import { withCtx as h } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as C } from "vue";
import { ElTag as x } from "element-plus";
const B = { __name: "process-box", props: { process: { type: Array, default: () => [] }, selectLineId: { type: Number, default: void 0 }, isSingle: { type: Boolean, default: false } }, emits: ["change"], setup(t, { emit: d }) {
  const r = d, c = p("productType", void 0);
  function u(s, l) {
    r("change", { process: s, item: l });
  }
  return (s, l) => {
    const f = x;
    return n(), a("div", null, [(n(true), a(i, null, g(t.process, (e) => (n(), a(i, { key: e.id }, [o(c) && o(c) === e.productType ? (n(), y(f, { key: 0, hit: "", effect: t.isSingle ? t.selectLineId === e.id ? "light" : "plain" : e.selected ? "light" : "plain", type: t.isSingle ? t.selectLineId === e.id ? "success" : "info" : e.selected ? "success" : "info", onClick: (S) => u(t.process, e) }, { default: h(() => [k(m(e.name), 1)]), _: 2 }, 1032, ["effect", "type", "onClick"])) : C("", true)], 64))), 128))]);
  };
} };
export {
  B as default
};
