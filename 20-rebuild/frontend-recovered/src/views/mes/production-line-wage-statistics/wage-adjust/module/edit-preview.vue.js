import { ref as V } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as Q } from "vue";
import { withCtx as l } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as N } from "vue";
import { unref as i } from "vue";
import { createElementBlock as P } from "vue";
import { Fragment as B } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as g } from "vue";
import { createCommentVNode as k } from "vue";
import { isRef as D } from "vue";
import { ElNotification as I } from "element-plus";
import { ElTableColumn as E } from "element-plus";
import { e as H } from "../../../../../modules/wage-adjust-5476478d.js";
import { u as M, o as U, aT as f } from "../../../../../shared/runtime.js";
import { _ as s } from "../../../../../modules/index-61ce89a1.js";
const A = { __name: "edit-preview", props: { visible: { type: Boolean, default: false }, modifiedData: { type: Array, default: () => [] }, showMoreColumn: { type: Boolean, default: false } }, emits: ["success", "update:visible"], setup(r, { emit: y }) {
  const w = y, h = r, m = V(false), { visible: p, handleClose: b } = M({ emit: w, props: h, field: "visible" }), { maxHeight: x } = U({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false, extraHeight: 150 }, p);
  async function W() {
    try {
      m.value = true;
      const d = h.modifiedData.map((o) => (console.log(o, "v"), { id: o.id, intermediatePaintWage: o.intermediatePaintWage, primerWage: o.primerWage, processId: o.processId, taskTypeEnum: o.taskTypeEnum, topcoatWage: o.topcoatWage, wage: o.wage, wageQuotaType: o.wageQuotaType }));
      await H(d), I({ title: "工价修改成功", type: "success" }), b(), w("success");
    } catch (d) {
      console.log("操作失败", d);
    } finally {
      m.value = false;
    }
  }
  return (d, o) => {
    const T = c("common-button"), t = E, v = c("common-table"), C = c("common-dialog");
    return _(), Q(C, { title: "工价修改预览", modelValue: i(p), "onUpdate:modelValue": o[0] || (o[0] = (a) => D(p) ? p.value = a : null), top: "5vh", "append-to-body": "", "before-close": i(b), width: "1500px" }, { titleRight: l(() => [e(T, { loading: m.value, size: "default", disabled: !r.modifiedData || r.modifiedData.length == 0, type: "primary", onClick: W }, { default: l(() => o[1] || (o[1] = [N(" 保 存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])]), default: l(() => [e(v, { data: r.modifiedData, "max-height": i(x), "empty-text": "未做改动", style: { width: "100%" } }, { default: l(() => [e(t, { label: "序号", type: "index", align: "center", width: "60" }), e(t, { prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), e(t, { prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), e(t, { prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), e(t, { prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "", "min-width": "130px" }), e(t, { prop: "wageQuotaTypeStr", align: "center", "show-overflow-tooltip": "", label: "核算单位", width: "70px" }), e(t, { align: "center", prop: "wage", label: "定额单价", "min-width": "100px" }, { default: l(({ row: a }) => [e(i(s), { old: a.sourceWage, new: a.wage }, null, 8, ["old", "new"])]), _: 1 }), r.showMoreColumn ? (_(), P(B, { key: 0 }, [e(t, { align: "center", prop: "primer", label: "底漆", "min-width": "100px" }, { default: l(() => [e(t, { prop: "primerWageQuotaType", align: "center", "show-overflow-tooltip": "", label: "核算单位", width: "70px" }, { default: l(({ row: a }) => {
      var n;
      return [u("span", null, g((n = i(f).V[a.primerWageQuotaType]) == null ? void 0 : n.C_UNIT), 1)];
    }), _: 1 }), e(t, { align: "center", prop: "primerWage", label: "定额单价", width: "150" }, { default: l(({ row: a }) => [e(i(s), { old: a.sourcePrimerWage, new: a.primerWage }, null, 8, ["old", "new"])]), _: 1 })]), _: 1 }), e(t, { align: "center", prop: "intermediatePaint", label: "中间漆", "min-width": "100px" }, { default: l(() => [e(t, { prop: "intermediatePaintWageQuotaType", align: "center", "show-overflow-tooltip": "", label: "核算单位", width: "70px" }, { default: l(({ row: a }) => {
      var n;
      return [u("span", null, g((n = i(f).V[a.intermediatePaintWageQuotaType]) == null ? void 0 : n.C_UNIT), 1)];
    }), _: 1 }), e(t, { align: "center", prop: "intermediatePaintWage", label: "定额单价", width: "150" }, { default: l(({ row: a }) => [e(i(s), { old: a.sourceIntermediatePaintWage, new: a.intermediatePaintWage }, null, 8, ["old", "new"])]), _: 1 })]), _: 1 }), e(t, { align: "center", prop: "topcoat", label: "面漆", "min-width": "100px" }, { default: l(() => [e(t, { prop: "topcoatWageQuotaType", align: "center", "show-overflow-tooltip": "", label: "核算单位", width: "70px" }, { default: l(({ row: a }) => {
      var n;
      return [u("span", null, g((n = i(f).V[a.topcoatWageQuotaType]) == null ? void 0 : n.C_UNIT), 1)];
    }), _: 1 }), e(t, { align: "center", prop: "topcoatWage", label: "定额单价", width: "150" }, { default: l(({ row: a }) => [e(i(s), { old: a.sourceTopcoatWage, new: a.topcoatWage }, null, 8, ["old", "new"])]), _: 1 })]), _: 1 })], 64)) : k("", true)]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  A as default
};
