import { inject as y } from "vue";
import { computed as B } from "vue";
import { ref as V } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as A } from "vue";
import { createBlock as C } from "vue";
import { withCtx as l } from "vue";
import { createVNode as e } from "vue";
import { unref as i } from "vue";
import { createTextVNode as k } from "vue";
import { isRef as M } from "vue";
import { ElMessage as H } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { e as N } from "../../../../../../modules/painting-26fedd54.js";
import { b_ as R, u as S, o as E, b as F, c as I } from "../../../../../../shared/runtime.js";
import { _ as T } from "../../../../../../modules/index-61ce89a1.js";
const $ = { __name: "batch-edit-area-preview", props: { visible: { type: Boolean, default: false }, data: { type: Array, default: () => [] } }, emits: ["saveSuccess", "update:visible"], setup(f, { emit: b }) {
  const m = b, u = f, _ = y("sourceMap"), r = B(() => u.data.filter((t) => R(t, _))), d = V(false), { visible: s, handleClose: p } = S({ emit: m, props: u, field: "visible" }), { maxHeight: g } = E({ mainBox: ".batch-edit-area-preview-dlg", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, s);
  async function h() {
    try {
      d.value = true;
      const t = r.value.map((a) => ({ id: a.id, surfaceArea: I(a.surfaceArea, "㎡", "mm²") }));
      await N(t), p(), m("saveSuccess"), H.success("更新成功");
    } catch (t) {
      console.log("面积批量修改", t);
    } finally {
      d.value = false;
    }
  }
  return (t, a) => {
    const w = c("common-button"), o = j, v = c("common-table"), x = c("common-dialog");
    return A(), C(x, { "custom-class": "batch-edit-area-preview-dlg", title: "面积修改预览", "append-to-body": "", modelValue: i(s), "onUpdate:modelValue": a[0] || (a[0] = (n) => M(s) ? s.value = n : null), width: "1200px", "before-close": i(p), top: "5vh" }, { titleRight: l(() => [e(w, { loading: d.value, disabled: i(F)(r.value), type: "primary", size: "default", onClick: h }, { default: l(() => a[1] || (a[1] = [k("保 存")])), _: 1, __: [1] }, 8, ["loading", "disabled"])]), default: l(() => [e(v, { data: r.value, "max-height": i(g), "return-source-data": "", "empty-text": "未做改动", "row-key": "id" }, { default: l(() => [e(o, { label: "序号", type: "index", align: "center", width: "60" }), e(o, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", align: "center", "min-width": "120px" }), e(o, { prop: "area.name", "show-overflow-tooltip": true, label: "区域", align: "center", "min-width": "120px" }), e(o, { prop: "serialNumber", label: "编号", align: "center", "min-width": "80px" }), e(o, { prop: "quantity", label: "编号", align: "center", "min-width": "80px" }), e(o, { label: "面积(㎡)", align: "center" }, { default: l((n) => [e(i(T), { old: n.row.sourceSurfaceArea, new: n.row.surfaceArea }, null, 8, ["old", "new"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  $ as default
};
