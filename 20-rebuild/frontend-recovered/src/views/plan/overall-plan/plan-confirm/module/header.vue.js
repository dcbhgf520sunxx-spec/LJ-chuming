import { openBlock as r } from "vue";
import { createElementBlock as u } from "vue";
import { withDirectives as p } from "vue";
import { unref as _ } from "vue";
import { createBlock as b } from "vue";
import { withCtx as e } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as s } from "vue";
import { ElCard as i } from "element-plus";
import { ElCol as g } from "element-plus";
import { ElRow as y } from "element-plus";
import { vLoading as v } from "element-plus";
import { _ as m, B as w, E as k } from "../../../../../shared/runtime.js";
const x = { __name: "header", setup(h) {
  const l = {}, { crud: n } = w(l);
  return (E, a) => {
    const t = i, d = g, c = y, f = v;
    return r(), u("div", null, [p((r(), b(c, { gutter: 30 }, { default: e(() => [o(d, { span: 4 }, { default: e(() => [o(t, { shadow: "hover", "body-style": { background: "#f0f9eb", color: "#67c23a" } }, { default: e(() => a[0] || (a[0] = [s(" 总计划100 ")])), _: 1, __: [0] })]), _: 1 }), o(d, { span: 4 }, { default: e(() => [o(t, { shadow: "hover", "body-style": { background: "#f0f9eb", color: "#67c23a" } }, { default: e(() => a[1] || (a[1] = [s(" 按期完成100 ")])), _: 1, __: [1] })]), _: 1 }), o(d, { span: 4 }, { default: e(() => [o(t, { shadow: "hover", "body-style": { background: "#f0f9eb", color: "#67c23a" } }, { default: e(() => a[2] || (a[2] = [s(" 未确认100 ")])), _: 1, __: [2] })]), _: 1 }), o(d, { span: 4 }, { default: e(() => [o(t, { shadow: "hover", "body-style": { background: "#f0f9eb", color: "#67c23a" } }, { default: e(() => a[3] || (a[3] = [s(" 已确认100 ")])), _: 1, __: [3] })]), _: 1 }), o(d, { span: 4 }, { default: e(() => [o(t, { class: "danger-card", shadow: "hover", "body-style": { background: "#fef0f0", color: "#f56c6c" } }, { default: e(() => a[4] || (a[4] = [s(" 已超期100 ")])), _: 1, __: [4] })]), _: 1 })]), _: 1 })), [[f, _(n).loading]]), o(_(k))]);
  };
} }, H = m(x, [["__scopeId", "data-v-cd917450"]]);
export {
  H as default
};
