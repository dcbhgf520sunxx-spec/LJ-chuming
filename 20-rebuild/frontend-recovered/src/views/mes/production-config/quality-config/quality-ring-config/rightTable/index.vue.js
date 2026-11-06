import { ref as F } from "vue";
import { inject as N } from "vue";
import { computed as w } from "vue";
import { watch as P } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as q } from "vue";
import { withDirectives as y } from "vue";
import { vShow as C } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as t } from "vue";
import { withCtx as o } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as S } from "vue";
import { unref as e } from "vue";
import { createBlock as h } from "vue";
import { createCommentVNode as E } from "vue";
import { ElMessageBox as I } from "element-plus";
import { ElTag as H } from "element-plus";
import { ElTooltip as $ } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { ElSwitch as M } from "element-plus";
import { vLoading as Q } from "element-plus";
import { c as Y, e as G } from "../../../../../../modules/quality-ring-config-c8639e5f.js";
import { D as K, x as z, pc as J, G as V, aS as r, an as W, P as X, pa as Z } from "../../../../../../shared/runtime.js";
import ee from "./module/header.vue.js";
import te from "./module/form.vue.js";
import ae from "./module/editFrom.vue.js";
import "../../../../../../modules/use-table-operate-4f84437f.js";
const ne = { class: "head-container" }, oe = { class: "item-content ellipsis-text" }, me = { __name: "index", props: { currentLine: { type: Object, default: () => {
} } }, setup(l) {
  const g = l, v = F(), L = N("maxHeight"), d = { ...Z.ring.com }, m = w(() => g.currentLine.id), T = w(() => [["penalty", ["to-thousand", K.YUAN]]]), { crud: n, columns: k, CRUD: x } = z({ title: "二级分类", sort: [], formStore: true, permission: { ...d }, optShow: { add: false, batchAdd: true }, crudApi: { ...Y }, queryOnPresenterCreated: false }, v);
  x.HOOK.beforeToQuery = () => {
    n.query.safetyClassId = m.value, n.query.factoryOrConstructionSite = g.currentLine.factoryOrConstructionSite;
  }, P(() => m.value, () => {
    n.toQuery();
  }, { deep: true, immediate: true });
  async function O(c, a) {
    try {
      await I.confirm('此操作将 "' + r.VL[a] + '" ' + c.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await G({ id: c.id, status: a }), n.refresh(), n.notify(r.VL[a] + "成功", x.NOTIFICATION_TYPE.SUCCESS);
    } catch (p) {
      console.log("变更状态", p), c.status = c.status === r.TRUE.V ? r.FALSE.V : r.TRUE.V;
    }
  }
  return (c, a) => {
    const p = H, U = $, i = j, B = M, D = R("common-table"), A = Q;
    return f(), q("div", null, [y(u("div", null, a[0] || (a[0] = [u("div", { class: "my-code" }, "点击二级分类查看详情", -1)]), 512), [[C, !m.value]]), y(u("div", null, [u("div", ne, [t(e(ee), null, { header: o(() => [t(p, { type: "primary" }, { default: o(() => [_("分类：" + S(e(J).VL[l.currentLine.factoryOrConstructionSite]), 1)]), _: 1 }), t(p, { type: "primary", style: { "margin-left": "10px" } }, { default: o(() => [a[1] || (a[1] = _(" 一级分类： ")), t(U, { class: "box-item", effect: "dark", content: l.currentLine.name, placement: "top" }, { default: o(() => [u("span", oe, S(l.currentLine.name || "-"), 1)]), _: 1 }, 8, ["content"])]), _: 1, __: [1] })]), _: 1 })]), y((f(), h(D, { ref_key: "tableRef", ref: v, data: e(n).data, "empty-text": e(n).emptyText, "max-height": e(L), style: { width: "100%" }, "data-format": T.value, "row-key": "id", onSelectionChange: e(n).selectionChangeHandler }, { default: o(() => [t(i, { label: "序号", type: "index", align: "center", width: "60" }), a[2] || (a[2] = _("> ")), e(k).visible(" ") ? (f(), h(i, { key: "name", prop: "name", label: "二级分类", align: "center" })) : E("", true), t(i, { key: "behaviorScore", prop: "behaviorScore", align: "center", width: "200px", label: "行为分" }), t(i, { key: "penalty", prop: "penalty", align: "center", width: "200px", label: "处罚（元）" }), t(i, { key: "status", prop: "status", label: "状态", align: "center", width: "100px" }, { default: o((s) => [t(B, { modelValue: s.row.status, "onUpdate:modelValue": (b) => s.row.status = b, disabled: !e(V)(d.editStatus), "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(r).TRUE.V, "inactive-value": e(r).FALSE.V, onChange: (b) => O(s.row, s.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])]), _: 1 }), e(V)([...d.edit, ...d.del]) ? (f(), h(i, { key: 1, label: "操作", width: "150px", align: "center", fixed: "right" }, { default: o((s) => [t(e(W), { data: s.row }, null, 8, ["data"])]), _: 1 })) : E("", true)]), _: 1, __: [2] }, 8, ["data", "empty-text", "max-height", "data-format", "onSelectionChange"])), [[A, e(n).loading]]), t(e(X)), t(e(te), { currentLine: l.currentLine }, null, 8, ["currentLine"]), t(ae)], 512), [[C, m.value]])]);
  };
} };
export {
  me as default
};
