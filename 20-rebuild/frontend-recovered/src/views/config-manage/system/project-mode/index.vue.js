import { ref as f } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as C } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as S } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as m } from "vue";
import { unref as e } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as s } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as B } from "vue";
import { toDisplayString as h } from "vue";
import { createCommentVNode as c } from "vue";
import { ElTableColumn as D } from "element-plus";
import { vLoading as M } from "element-plus";
import { c as P, m as j } from "./module/mode-change.vue.js";
import { _ as E, x as N, g9 as p, o as R, c0 as H, P as T, G as A } from "../../../../shared/runtime.js";
import L from "./module/header.vue.js";
const U = { class: "app-container" }, $ = { class: "head-container" }, q = { __name: "index", setup(z) {
  const b = { add: false, edit: false, del: false, download: false }, u = f(), r = f(false), { crud: n, columns: _ } = N({ title: "项目模式", sort: [], permission: { ...p }, optShow: { ...b }, crudApi: { ...P }, hasPagination: true }, u), { maxHeight: g } = R({ wrapperBox: ".projectMode", paginate: true, extraHeight: 60 });
  return (G, o) => {
    const w = v("common-button"), l = D, y = v("common-table"), k = C("permission"), V = M;
    return a(), S("div", U, [d("div", $, [m(e(L))]), x((a(), s(w, { size: "default", type: "primary", onClick: o[0] || (o[0] = (t) => r.value = true), style: { "margin-bottom": "10px" } }, { default: i(() => o[2] || (o[2] = [B("修改项目模式")])), _: 1, __: [2] })), [[k, e(p).edit]]), x((a(), s(y, { ref_key: "tableRef", ref: u, data: e(n).data, "empty-text": e(n).emptyText, "max-height": e(g), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: i(() => [m(l, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(_).visible("name") ? (a(), s(l, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "项目名称", "min-width": "150" }, { default: i((t) => [d("div", null, h(t.row.name), 1)]), _: 1 })) : c("", true), e(_).visible("mode") ? (a(), s(l, { key: "mode", prop: "mode", "show-overflow-tooltip": true, label: "项目模式", "min-width": "150" }, { default: i((t) => [d("div", null, h(t.row.mode ? e(H).VL[t.row.mode] : "-"), 1)]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[V, e(n).loading]]), m(e(T)), e(A)(e(p).edit) ? (a(), s(e(j), { key: 0, modelValue: r.value, "onUpdate:modelValue": o[1] || (o[1] = (t) => r.value = t), onSuccess: e(n).toQuery }, null, 8, ["modelValue", "onSuccess"])) : c("", true)]);
  };
} }, K = E(q, [["__scopeId", "data-v-ed0b6335"]]);
export {
  K as default
};
