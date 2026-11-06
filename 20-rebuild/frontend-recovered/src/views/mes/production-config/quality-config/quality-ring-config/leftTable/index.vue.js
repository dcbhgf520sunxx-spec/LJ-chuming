import { inject as T } from "vue";
import { ref as B } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as O } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as e } from "vue";
import { unref as t } from "vue";
import { withDirectives as U } from "vue";
import { createBlock as y } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as g } from "vue";
import { createCommentVNode as F } from "vue";
import { ElMessageBox as L } from "element-plus";
import { ElTableColumn as R } from "element-plus";
import { InfoFilled as A } from "@element-plus/icons-vue";
import { ElIcon as D } from "element-plus";
import { ElSwitch as I } from "element-plus";
import { vLoading as P } from "element-plus";
import { c as $, e as H } from "../../../../../../modules/quality-ring-config-c8639e5f.js";
import { x as j, pc as q, y as M, aS as l, G, an as K, P as Q, pa as Y } from "../../../../../../shared/runtime.js";
import z from "./module/header.vue.js";
import J from "./module/form.vue.js";
import W from "./module/editFrom.vue.js";
import "../../../../../../modules/use-table-operate-4f84437f.js";
const X = { class: "head-container" }, Z = { style: { display: "inline-block" } }, re = { __name: "index", emits: ["click-line", "del-line"], setup(ee, { emit: w }) {
  const c = { ...Y.ring.com }, u = w, b = T("maxHeight"), p = B(), { crud: r, CRUD: _ } = j({ title: "一级分类", sort: [], permission: { ...c }, optShow: { add: false, batchAdd: true }, crudApi: { ...$ } }, p);
  _.HOOK.afterDelete = () => {
    u("del-line", {});
  };
  const C = (n) => {
    u("click-line", n);
  };
  async function x(n, s) {
    try {
      await L.confirm('此操作将 "' + l.VL[s] + '" ' + n.name + ", 是否继续？", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await H({ id: n.id, status: s }), r.refresh(), r.notify(l.VL[s] + "成功", _.NOTIFICATION_TYPE.SUCCESS);
    } catch (o) {
      console.log("变更状态", o), n.status = n.status === l.TRUE.V ? l.FALSE.V : l.TRUE.V;
    }
  }
  return (n, s) => {
    const o = R, v = A, k = D, E = I, V = N("common-table"), S = P;
    return m(), O("div", null, [d("div", X, [e(t(z))]), U((m(), y(V, { ref_key: "tableRef", ref: p, data: t(r).data, "empty-text": t(r).emptyText, "max-height": t(b), style: { width: "100%" }, "row-key": "id", onCurrentChange: C }, { default: i(() => [e(o, { label: "序号", type: "index", align: "center", width: "60" }), e(o, { key: "factoryOrConstructionSite", prop: "factoryOrConstructionSite", label: "分类", align: "center" }, { default: i((a) => [h(g(t(q).VL[a.row.factoryOrConstructionSite]), 1)]), _: 1 }), e(o, { key: "type", prop: "type", label: "类型", align: "center" }, { default: i((a) => [h(g(t(M).VL[a.row.type]), 1)]), _: 1 }), e(o, { key: "name", prop: "name", "show-overflow-tooltip": "", label: "一级分类", align: "center" }), e(o, { key: "serialNumber", "show-overflow-tooltip": "", prop: "serialNumber", align: "center", label: "代码" }), e(o, { key: "status", prop: "status", label: "状态", align: "center", width: "80px" }, { header: i(() => [d("div", Z, [s[0] || (s[0] = d("span", null, "状态", -1)), e(k, null, { default: i(() => [e(v)]), _: 1 })])]), default: i((a) => [e(E, { modelValue: a.row.status, "onUpdate:modelValue": (f) => a.row.status = f, "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": t(l).TRUE.V, "inactive-value": t(l).FALSE.V, onClick: (f) => x(a.row, a.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "onClick"])]), _: 1 }), t(G)([...c.edit, ...c.del]) ? (m(), y(o, { key: 0, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: i((a) => [e(t(K), { data: a.row }, null, 8, ["data"])]), _: 1 })) : F("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[S, t(r).loading]]), e(t(Q)), e(t(J)), e(W)]);
  };
} };
export {
  re as default
};
