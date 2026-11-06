import { ref as r } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as B } from "vue";
import { createVNode as t } from "vue";
import { withCtx as e } from "vue";
import { createElementVNode as g } from "vue";
import { unref as n } from "vue";
import { createBlock as b } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as N } from "vue";
import { createCommentVNode as C } from "vue";
import { ElTableColumn as D } from "element-plus";
import { ElCard as L } from "element-plus";
import { ElCol as R } from "element-plus";
import { ElTag as V } from "element-plus";
import { ElRow as j } from "element-plus";
import { bv as T, dj as z, i as c, G as A } from "../../../../shared/runtime.js";
import O from "./dict-detail/index.vue.js";
import "./dict-detail/module/form.vue.js";
import "./dict-detail/module/batch-form.vue.js";
const S = { class: "app-container" }, I = { __name: "index", setup(G) {
  const l = r(), a = r({}), h = r(T.toArr(z));
  function y(s) {
    c(s) ? a.value = Object.assign(a.value, s) : a.value = {};
  }
  return (s, o) => {
    const m = D, v = f("common-table"), p = L, d = R, k = V, w = f("common-button"), E = j;
    return i(), B("div", S, [t(E, { gutter: 10 }, { default: e(() => [t(d, { span: 6, style: { "margin-bottom": "10px" } }, { default: e(() => [t(p, { class: "line-box box-card" }, { header: e(() => o[0] || (o[0] = [g("span", { style: { "line-height": "28px" } }, "合同目录表字段", -1)])), default: e(() => [t(v, { ref: "tableRef", "highlight-current-row": "", data: h.value, "empty-text": "暂无数据", style: { width: "100%", "margin-top": "10px" }, onCurrentChange: y }, { default: e(() => [t(m, { label: "序号", type: "index", align: "center", width: "60" }), t(m, { key: "L", prop: "L", "show-overflow-tooltip": true, label: "字段", "min-width": "140px" })]), _: 1 }, 8, ["data"])]), _: 1 })]), _: 1 }), t(d, { span: 18 }, { default: e(() => [t(p, { class: "box-card team-card" }, { header: e(() => {
      var u, _;
      return [o[2] || (o[2] = g("span", { style: { "margin-right": "5px" } }, "明细", -1)), n(c)(a.value) ? (i(), b(k, { key: 0, size: "large" }, { default: e(() => [x(N(a.value.L), 1)]), _: 1 })) : C("", true), n(c)(a.value) && n(A)((_ = (u = l.value) == null ? void 0 : u.permission) == null ? void 0 : _.add) ? (i(), b(w, { key: 1, size: "default", style: { float: "right", padding: "6px 10px", "margin-bottom": "0px" }, type: "primary", icon: "el-icon-plus", onClick: l.value.toAdd }, { default: e(() => o[1] || (o[1] = [x(" 新增 ")])), _: 1, __: [1] }, 8, ["onClick"])) : C("", true)];
    }), default: e(() => [t(n(O), { ref_key: "dictDetailRef", ref: l, line: a.value }, null, 8, ["line"])]), _: 1 })]), _: 1 })]), _: 1 })]);
  };
} };
export {
  I as default
};
