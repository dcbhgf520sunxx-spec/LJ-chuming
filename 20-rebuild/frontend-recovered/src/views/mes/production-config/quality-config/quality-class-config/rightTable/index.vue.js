import { ref as q } from "vue";
import { inject as A } from "vue";
import { computed as C } from "vue";
import { watch as F } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as P } from "vue";
import { withDirectives as y } from "vue";
import { vShow as b } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as t } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as S } from "vue";
import { unref as e } from "vue";
import { createBlock as g } from "vue";
import { createCommentVNode as V } from "vue";
import { ElMessageBox as R } from "element-plus";
import { ElTag as I } from "element-plus";
import { ElTableColumn as H } from "element-plus";
import { ElSwitch as $ } from "element-plus";
import { vLoading as j } from "element-plus";
import { c as Q, e as M } from "../../../../../../modules/quality-class-config-61380f5b.js";
import { D as Y, x as G, pc as K, G as E, aS as o, an as z, P as J, pa as W } from "../../../../../../shared/runtime.js";
import X from "./module/header.vue.js";
import Z from "./module/form.vue.js";
import ee from "./module/editFrom.vue.js";
import "../../../../../../modules/use-table-operate-4f84437f.js";
const te = { class: "head-container" }, ce = { __name: "index", props: { currentLine: { type: Object, default: () => {
} } }, setup(c) {
  const _ = c, v = q(), L = A("maxHeight"), u = { ...W.class.com }, T = C(() => [["penalty", ["to-thousand", Y.YUAN]]]), d = C(() => _.currentLine.id), { crud: a, columns: k, CRUD: w } = G({ title: "二级分类", sort: [], formStore: true, permission: { ...u }, optShow: { add: false, batchAdd: true }, crudApi: { ...Q }, queryOnPresenterCreated: false }, v);
  w.HOOK.beforeToQuery = () => {
    a.query.qualityClassId = d.value, a.query.factoryOrConstructionSite = _.currentLine.factoryOrConstructionSite;
  }, F(() => d.value, () => {
    a.toQuery();
  }, { deep: true, immediate: true });
  async function O(s, n) {
    try {
      await R.confirm('此操作将 "' + o.VL[n] + '" ' + s.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await M({ id: s.id, status: n }), a.refresh(), a.notify(o.VL[n] + "成功", w.NOTIFICATION_TYPE.SUCCESS);
    } catch (m) {
      console.log("变更状态", m), s.status = s.status === o.TRUE.V ? o.FALSE.V : o.TRUE.V;
    }
  }
  return (s, n) => {
    const m = I, r = H, U = $, B = N("common-table"), D = j;
    return p(), P("div", null, [y(f("div", null, n[0] || (n[0] = [f("div", { class: "my-code" }, "点击二级分类查看详情", -1)]), 512), [[b, !d.value]]), y(f("div", null, [f("div", te, [t(e(X), null, { header: l(() => [t(m, null, { default: l(() => [h("分类：" + S(e(K).VL[c.currentLine.factoryOrConstructionSite]), 1)]), _: 1 }), t(m, { style: { "margin-left": "10px" } }, { default: l(() => [h("一级分类：" + S(c.currentLine.name), 1)]), _: 1 })]), _: 1 })]), y((p(), g(B, { ref_key: "tableRef", ref: v, data: e(a).data, "empty-text": e(a).emptyText, "max-height": e(L), style: { width: "100%" }, "data-format": T.value, "row-key": "id", onSelectionChange: e(a).selectionChangeHandler }, { default: l(() => [t(r, { label: "序号", type: "index", align: "center", width: "60" }), n[1] || (n[1] = h("> ")), e(k).visible(" ") ? (p(), g(r, { key: "name", prop: "name", label: "二级分类", align: "center" })) : V("", true), t(r, { key: "behaviorScore", prop: "behaviorScore", align: "center", width: "200px", label: "行为分" }), t(r, { key: "penalty", prop: "penalty", align: "center", width: "200px", label: "处罚（元）" }), t(r, { key: "status", prop: "status", label: "状态", align: "center", width: "100px" }, { default: l((i) => [t(U, { modelValue: i.row.status, "onUpdate:modelValue": (x) => i.row.status = x, disabled: !e(E)(u.editStatus), "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(o).TRUE.V, "inactive-value": e(o).FALSE.V, onChange: (x) => O(i.row, i.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])]), _: 1 }), e(E)([...u.edit, ...u.del]) ? (p(), g(r, { key: 1, label: "操作", width: "150px", align: "center", fixed: "right" }, { default: l((i) => [t(e(z), { data: i.row }, null, 8, ["data"])]), _: 1 })) : V("", true)]), _: 1, __: [1] }, 8, ["data", "empty-text", "max-height", "data-format", "onSelectionChange"])), [[D, e(a).loading]]), t(e(J)), t(e(Z), { currentLine: c.currentLine }, null, 8, ["currentLine"]), t(ee)], 512), [[b, d.value]])]);
  };
} };
export {
  ce as default
};
