import { ref as I } from "vue";
import { inject as P } from "vue";
import { computed as B } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as l } from "vue";
import { createBlock as h } from "vue";
import { withCtx as c } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as C } from "vue";
import { unref as s } from "vue";
import { toDisplayString as g } from "vue";
import { createElementBlock as d } from "vue";
import { Fragment as S } from "vue";
import { createCommentVNode as U } from "vue";
import { isRef as A } from "vue";
import { ElMessage as R } from "element-plus";
import { ElPopconfirm as J } from "element-plus";
import { ElTableColumn as M } from "element-plus";
import { ElCheckbox as z } from "element-plus";
import { s as F } from "../../../../modules/mes-receipt-review-377f871a.js";
import { u as H, i as f, am as _, z as W, c as y, b as V } from "../../../../shared/runtime.js";
const q = { key: 0 }, G = { key: 1 }, K = { key: 0 }, Q = { key: 1 }, X = { key: 0 }, Y = { key: 1 }, te = { __name: "submit-review", props: { modelValue: { type: Boolean, require: true }, submitObj: { type: Object, default: () => {
} }, handleDetailList: { type: Array, default: () => [] }, maxHeight: { type: Number, default: 100 } }, emits: ["success", "update:modelValue"], setup(x, { emit: j }) {
  const L = j, p = x, b = I(false), O = P("mainCurrentRow"), { visible: u, handleClose: E } = H({ emit: L, props: p }), T = B(() => {
    var m, n;
    const a = [];
    return f(p.submitObj) && f((m = p.submitObj) == null ? void 0 : m.wmsPickingDetailDTOList) && JSON.parse(JSON.stringify((n = p.submitObj) == null ? void 0 : n.wmsPickingDetailDTOList)).forEach((i) => {
      i.basicClass === _.STEEL_PLATE.V || (i.transactDisabled = (i.handlingLength || 0) + (i.nowLength || 0) >= (i.pickingLength || 0)), a.push(i);
    }), JSON.parse(JSON.stringify(p.handleDetailList)).forEach((e) => {
      e.wmsPickingDetailDTOList.forEach((i) => {
        a.findIndex((w) => w.id === i.id) < 0 && a.push(i);
      });
    }), a;
  });
  async function D() {
    try {
      b.value = true;
      const a = [], r = [];
      if (T.value.forEach((n) => {
        n.isTransactStatus && !a.includes(n.id) && (a.push(n.id), r.includes(n.pickingId) || r.push(n.pickingId)), n.realCurrent && r.push(n.pickingId);
      }), V(p.submitObj) && V(a)) return;
      let m = {};
      f(p.submitObj) ? m = { ...p.submitObj, completePickingDetailIds: a, pickingIds: r } : m = { completePickingDetailIds: a, pickingIds: r }, await F(m), R.success("提交成功"), L("success"), E();
    } catch (a) {
      console.log("出库办理", a);
    } finally {
      b.value = false;
    }
  }
  return (a, r) => {
    const m = k("common-button"), n = J, e = M, i = z, w = k("common-table"), N = k("common-drawer");
    return l(), h(N, { ref: "drawerRef", modelValue: s(u), "onUpdate:modelValue": r[0] || (r[0] = (t) => A(u) ? u.value = t : null), "before-close": s(E), title: "本次办理明细", "show-close": true, "close-on-click-modal": false, size: "85%", "custom-class": "raw-mat-application-review-form" }, { titleRight: c(() => [o(n, { "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "red", title: "确定提交吗?", onConfirm: D }, { reference: c(() => [o(m, { loading: b.value, size: "default", type: "success" }, { default: c(() => r[1] || (r[1] = [C("提交")])), _: 1, __: [1] }, 8, ["loading"])]), _: 1 })]), content: c(() => [s(u) ? (l(), h(w, { key: 0, data: T.value, "max-height": x.maxHeight - 50, "row-key": "id", "show-empty-symbol": false, "return-source-data": "" }, { default: c(() => [o(e, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), o(e, { key: "project", prop: "project", label: "项目", "show-overflow-tooltip": "", "min-width": "150px", align: "left" }, { default: c(({ row: t }) => [C(g(s(f)(t.project) ? s(W)(t.project) : "-"), 1)]), _: 1 }), o(e, { key: "taskOrderNumber", prop: "taskOrderNumber", "show-overflow-tooltip": "", "min-width": "150px", label: "领料单", align: "center" }), o(e, { key: "mesWorkshop.name", prop: "mesWorkshop.name", "show-overflow-tooltip": "", width: "100px", label: "车间", align: "center" }), o(e, { key: "materialType", prop: "materialType", "show-overflow-tooltip": "", width: "100px", label: "物料种类", align: "center" }), s(O).basicClass === s(_).SECTION_STEEL.V ? (l(), h(e, { key: "specification", prop: "specification", "show-overflow-tooltip": "", "min-width": "100px", label: "规格", align: "right" })) : (l(), h(e, { key: "thick", prop: "thick", label: "厚度(mm)", "show-overflow-tooltip": "", width: "100px", align: "right" })), o(e, { key: "material", prop: "material", label: "材质", "show-overflow-tooltip": "", width: "100px", align: "right" }), o(e, { key: "accountingUnit", prop: "accountingUnit", "show-overflow-tooltip": "", width: "100px", label: "单位", align: "right" }), s(O).basicClass === s(_).SECTION_STEEL.V ? (l(), d(S, { key: 2 }, [o(e, { key: "pickingLength", prop: "pickingLength", label: "领用长度(m)", align: "center", "min-width": "80px" }, { default: c(({ row: t }) => [t.pickingLength ? (l(), d("span", q, g(s(y)(t.pickingLength, "mm", "m", 3)), 1)) : (l(), d("span", G, "-"))]), _: 1 }), o(e, { label: "已办理长度(m)", "show-overflow-tooltip": "", "min-width": "100px", key: "handlingLength", prop: "handlingLength", align: "center" }, { default: c(({ row: t }) => [t.handlingLength ? (l(), d("span", K, g(s(y)(t.handlingLength, "mm", "m", 3)), 1)) : (l(), d("span", Q, "-"))]), _: 1 }), o(e, { label: "本次办理长度(m)", "show-overflow-tooltip": "", "min-width": "100px", key: "nowLength", prop: "nowLength", align: "center" }, { default: c(({ row: t }) => [t.nowLength ? (l(), d("span", X, g(s(y)(t.nowLength, "mm", "m", 3)), 1)) : (l(), d("span", Y, "-"))]), _: 1 })], 64)) : (l(), d(S, { key: 3 }, [o(e, { key: "pickingAmount", prop: "pickingAmount", label: "申请量", "show-overflow-tooltip": "", "min-width": "100px", align: "right" }), o(e, { key: "nowMete", prop: "nowMete", label: "本次办理量", "show-overflow-tooltip": "", "min-width": "100px", align: "right" }), o(e, { key: "volume", prop: "volume", label: "累计已办理", "show-overflow-tooltip": "", "min-width": "100px", align: "right" })], 64)), o(e, { key: "isTransactStatus", prop: "isTransactStatus", label: "是否齐套", align: "center", width: "80" }, { default: c(({ row: t }) => [o(i, { modelValue: t.isTransactStatus, "onUpdate:modelValue": (v) => t.isTransactStatus = v, label: "齐套", disabled: t.transactDisabled }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])) : U("", true)]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  te as default
};
