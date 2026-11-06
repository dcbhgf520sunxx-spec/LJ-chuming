import { ref as _ } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as R } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as B } from "vue";
import { createVNode as c } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as f } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as l } from "vue";
import { unref as a } from "vue";
import { createTextVNode as g } from "vue";
import { createCommentVNode as m } from "vue";
import { ElTableColumn as E } from "element-plus";
import { ElCard as V } from "element-plus";
import { vLoading as O } from "element-plus";
import { _ as S, o as H, x as P, eE as v, eF as G, eG as T, i as U, G as $, an as j } from "../../../../shared/runtime.js";
import q from "./module/form.vue.js";
import F from "./module/batch-form.vue.js";
import "../../../../modules/use-table-operate-4f84437f.js";
const K = { class: "app-container" }, L = { style: { "margin-bottom": "10px" } }, W = { __name: "index", setup(z) {
  const w = { batchAdd: true, add: false, edit: false, del: false, download: false }, h = _(), d = _([]), n = _([]), { maxHeight: y } = H({ paginate: false }), { CRUD: k, crud: u, columns: p } = P({ title: "模块小数精度配置", sort: ["id.desc"], permission: { ...v }, optShow: { ...w }, crudApi: { ...G } }, h);
  A();
  async function A() {
    d.value = [];
    try {
      const { content: i } = await T(), e = i.filter((t) => t.name === "WMS" || t.name === "合同管理");
      U(e) && d.value.push(...e);
    } catch (i) {
      console.log(i);
    }
  }
  return k.HOOK.handleRefresh = (i, { data: { content: e = [] } }) => {
    n.value = [], console.log(e, "dasdadasd"), e.forEach((t) => {
      n.value.indexOf(t.menuId) < 0 && n.value.push(t.menuId);
    });
  }, (i, e) => {
    const t = b("common-button"), r = E, C = b("common-table"), I = V, N = R("permission"), M = O;
    return o(), B("div", K, [c(I, { shadow: "always", class: "common-tax-rate" }, { header: s(() => e[0] || (e[0] = [f("div", { class: "clearfix" }, [f("span", { class: "card-title" }, "模块小数精度配置")], -1)])), default: s(() => [f("div", L, [x((o(), l(t, { type: "primary", onClick: a(u).toAdd }, { default: s(() => e[1] || (e[1] = [g("添加")])), _: 1, __: [1] }, 8, ["onClick"])), [[N, a(v).add]])]), x((o(), l(C, { ref_key: "tableRef", ref: h, "max-height": a(y), data: a(u).data, "row-key": "name" }, { default: s(() => [a(p).visible("menuName") ? (o(), l(r, { key: "menuName", "show-overflow-tooltip": true, prop: "menuName", label: "模块", align: "center" })) : m("", true), a(p).visible("type") ? (o(), l(r, { key: "type", "show-overflow-tooltip": true, prop: "type", label: "小数类型", align: "center", width: "120" }, { default: s(() => e[2] || (e[2] = [g(" 单价 ")])), _: 1 })) : m("", true), a(p).visible("scale") ? (o(), l(r, { key: "scale", "show-overflow-tooltip": true, prop: "scale", label: "小数精度", align: "left" })) : m("", true), a($)(a(v).edit) ? (o(), l(r, { key: 3, label: "操作", width: "120px", align: "center", fixed: "right" }, { default: s(({ row: D }) => [c(a(j), { data: D, "show-edit": false }, null, 8, ["data"])]), _: 1 })) : m("", true)]), _: 1 }, 8, ["max-height", "data"])), [[M, a(u).loading]])]), _: 1 }), c(q, { menuArr: d.value, disabledId: n.value }, null, 8, ["menuArr", "disabledId"]), c(a(F), { menuArr: d.value, disabledId: n.value }, null, 8, ["menuArr", "disabledId"])]);
  };
} }, ee = S(W, [["__scopeId", "data-v-f91247c0"]]);
export {
  ee as default
};
