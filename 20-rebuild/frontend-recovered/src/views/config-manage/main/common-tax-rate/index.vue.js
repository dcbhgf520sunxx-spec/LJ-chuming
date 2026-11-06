import { useStore as g } from "vuex";
import { ref as v } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as r } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as p } from "vue";
import { withDirectives as y } from "vue";
import { createBlock as n } from "vue";
import { unref as a } from "vue";
import { createCommentVNode as i } from "vue";
import { ElTableColumn as O } from "element-plus";
import { ElCard as D } from "element-plus";
import { vLoading as B } from "element-plus";
import { _ as E, x as S, eB as u, eC as V, eD as T, G as H, an as K } from "../../../../shared/runtime.js";
import L from "./module/form.vue.js";
const N = { class: "app-container" }, A = { __name: "index", setup(P) {
  const d = g(), x = { add: false, edit: false, del: false, download: false }, m = v(), { CRUD: l, crud: _, columns: f } = S({ title: "税率设定", sort: ["id.desc"], permission: { ...u }, optShow: { ...x }, crudApi: { ...V } }, m);
  return l.HOOK.handleRefresh = (h, { data: { content: o = [] } }) => {
    o.forEach((e) => {
      e.name = T.VL[e.classification], e.taxRate = e.taxRateList.map((c) => `${c}%`).join("、");
    });
  }, l.HOOK.afterSubmit = () => {
    d.dispatch("config/fetchTaxRate");
  }, l.HOOK.afterDelete = () => {
    d.dispatch("config/fetchTaxRate");
  }, (h, o) => {
    const e = O, c = k("common-table"), w = D, R = B;
    return t(), C("div", N, [r(w, { shadow: "always", class: "common-tax-rate" }, { header: s(() => o[0] || (o[0] = [p("div", { class: "clearfix" }, [p("span", { class: "card-title" }, "常用税率配置")], -1)])), default: s(() => [y((t(), n(c, { ref_key: "tableRef", ref: m, data: a(_).data, "row-key": "name" }, { default: s(() => [a(f).visible("name") ? (t(), n(e, { key: "name", "show-overflow-tooltip": true, prop: "name", label: "种类", align: "center", width: "120" })) : i("", true), a(f).visible("taxRate") ? (t(), n(e, { key: "taxRate", "show-overflow-tooltip": true, prop: "taxRate", label: "税率", align: "left" })) : i("", true), a(H)(a(u).edit) ? (t(), n(e, { key: 2, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: s(({ row: b }) => [r(a(K), { data: b, "show-del": false }, null, 8, ["data"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data"])), [[R, a(_).loading]])]), _: 1 }), r(L)]);
  };
} }, F = E(A, [["__scopeId", "data-v-13d058e1"]]);
export {
  F as default
};
