import { inject as V } from "vue";
import { ref as S } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as e } from "vue";
import { unref as t } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as h } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as O } from "vue";
import { toDisplayString as U } from "vue";
import { createCommentVNode as F } from "vue";
import { ElMessageBox as R } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { InfoFilled as D } from "@element-plus/icons-vue";
import { ElIcon as I } from "element-plus";
import { ElSwitch as L } from "element-plus";
import { vLoading as P } from "element-plus";
import { c as $, e as H } from "../../../../../../modules/quality-class-config-61380f5b.js";
import { x as j, pc as q, aS as i, G as M, an as G, P as K, pa as Q } from "../../../../../../shared/runtime.js";
import Y from "./module/header.vue.js";
import z from "./module/form.vue.js";
import J from "./module/editFrom.vue.js";
import "../../../../../../modules/use-table-operate-4f84437f.js";
const W = { class: "head-container" }, X = { style: { display: "inline-block" } }, se = { __name: "index", emits: ["click-line", "del-line"], setup(Z, { emit: y }) {
  const c = { ...Q.class.com }, u = y, g = V("maxHeight"), p = S(), { crud: r, CRUD: _ } = j({ title: "一级分类", sort: [], permission: { ...c }, optShow: { add: false, batchAdd: true }, crudApi: { ...$ } }, p);
  _.HOOK.afterDelete = () => {
    u("del-line", {});
  };
  const w = (n) => {
    u("click-line", n);
  };
  async function C(n, l) {
    try {
      await R.confirm('此操作将 "' + i.VL[l] + '" ' + n.name + ", 是否继续？", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await H({ id: n.id, status: l }), r.refresh(), r.notify(i.VL[l] + "成功", _.NOTIFICATION_TYPE.SUCCESS);
    } catch (a) {
      console.log("变更状态", a), n.status = n.status === i.TRUE.V ? i.FALSE.V : i.TRUE.V;
    }
  }
  return (n, l) => {
    const a = A, x = D, b = I, v = L, k = T("common-table"), E = P;
    return m(), B("div", null, [d("div", W, [e(t(Y))]), N((m(), h(k, { ref_key: "tableRef", ref: p, data: t(r).data, "empty-text": t(r).emptyText, "max-height": t(g), style: { width: "100%" }, "row-key": "id", onCurrentChange: w }, { default: s(() => [e(a, { label: "序号", type: "index", align: "center", width: "60" }), e(a, { key: "factoryOrConstructionSite", prop: "factoryOrConstructionSite", label: "分类", align: "center" }, { default: s((o) => [O(U(t(q).VL[o.row.factoryOrConstructionSite]), 1)]), _: 1 }), e(a, { key: "name", prop: "name", "show-overflow-tooltip": "", label: "一级分类", align: "center" }), e(a, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", align: "center", label: "代码" }), e(a, { key: "status", prop: "status", label: "状态", align: "center", width: "80px" }, { header: s(() => [d("div", X, [l[0] || (l[0] = d("span", null, "状态", -1)), e(b, null, { default: s(() => [e(x)]), _: 1 })])]), default: s((o) => [e(v, { modelValue: o.row.status, "onUpdate:modelValue": (f) => o.row.status = f, "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": t(i).TRUE.V, "inactive-value": t(i).FALSE.V, onClick: (f) => C(o.row, o.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "onClick"])]), _: 1 }), t(M)([...c.edit, ...c.del]) ? (m(), h(a, { key: 0, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: s((o) => [e(t(G), { data: o.row }, null, 8, ["data"])]), _: 1 })) : F("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[E, t(r).loading]]), e(t(K)), e(t(z)), e(J)]);
  };
} };
export {
  se as default
};
