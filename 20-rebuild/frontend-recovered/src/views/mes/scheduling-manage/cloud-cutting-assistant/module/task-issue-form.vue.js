import { ref as y } from "vue";
import { watch as N } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as x } from "vue";
import { createBlock as E } from "vue";
import { withCtx as a } from "vue";
import { createVNode as l } from "vue";
import { withModifiers as F } from "vue";
import { createTextVNode as D } from "vue";
import { createElementVNode as c } from "vue";
import { toDisplayString as f } from "vue";
import { unref as w } from "vue";
import { isRef as B } from "vue";
import { ElMessage as z } from "element-plus";
import { ElFormItem as P } from "element-plus";
import { ElDescriptionsItem as j } from "element-plus";
import { ElDatePicker as q } from "element-plus";
import { ElDescriptions as L } from "element-plus";
import { ElForm as M } from "element-plus";
import { f as O } from "../../../../../modules/cloud-cutting-assistant-43dc84e4.js";
import { _ as U, u as S, qw as A } from "../../../../../shared/runtime.js";
const G = { class: "form" }, H = { __name: "task-issue-form", props: { visible: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentTreeData: { type: Object, default: () => {
} } }, emits: ["success", "update:visible"], setup(r, { emit: h }) {
  const k = h, u = y(), _ = y(false), n = r, d = y({ askCompleteTime: void 0 }), { visible: b, handleClose: T } = S({ emit: k, props: n, field: "visible" });
  N(() => n.visible, async (v) => {
    var t, i;
    v && (await ((t = u.value) == null ? void 0 : t.resetFields()), await ((i = u.value) == null ? void 0 : i.clearValidate()));
  }, { immediate: true });
  const C = { askCompleteTime: [{ required: true, message: "请选择完成日期", trigger: "change" }] };
  async function I() {
    var t, i, o, s, p;
    if (await u.value.validate()) try {
      _.value = true;
      const m = { askCompleteTime: d.value.askCompleteTime, cloudcutId: (t = n.currentRow) == null ? void 0 : t.cloudcutId, id: (i = n.currentRow) == null ? void 0 : i.id, filePath: (o = n.currentRow) == null ? void 0 : o.filePath, fileName: (s = n.currentRow) == null ? void 0 : s.fileName, machineToolId: (p = n.currentRow) == null ? void 0 : p.machineToolId };
      await O([m]), z.success("下发成功"), T(), k("success");
    } catch (m) {
      console.log(m, "提交失败");
    } finally {
      _.value = false;
    }
  }
  return (v, t) => {
    const i = g("common-button"), o = P, s = j, p = q, m = L, R = M, V = g("common-dialog");
    return x(), E(V, { title: "数控任务下发", visible: w(b), "onUpdate:visible": t[1] || (t[1] = (e) => B(b) ? b.value = e : null), "before-close": w(T), "append-to-body": true, "close-on-click-modal": false, width: "500px" }, { titleRight: a(() => [l(i, { size: "default", loading: _.value, class: "filter-item", type: "primary", onClick: F(I, ["stop"]) }, { default: a(() => t[2] || (t[2] = [D(" 确 认 ")])), _: 1, __: [2] }, 8, ["loading"])]), default: a(() => [c("div", G, [l(R, { ref_key: "formRef", ref: u, model: d.value, rules: C, size: "default", class: "demo-form" }, { default: a(() => [l(m, { border: "", column: 1 }, { default: a(() => [l(s, { "label-class-name": "my-all-label", label: "工单号" }, { default: a(() => [l(o, { prop: "orderId" }, { default: a(() => {
      var e;
      return [c("span", null, f(((e = r.currentTreeData) == null ? void 0 : e.name) || "-"), 1)];
    }), _: 1 })]), _: 1 }), l(s, { "label-class-name": "my-all-label", label: "车间" }, { default: a(() => [l(o, { prop: "workshopName" }, { default: a(() => {
      var e;
      return [c("span", null, f(((e = r.currentTreeData) == null ? void 0 : e.workshopName) || "-"), 1)];
    }), _: 1 })]), _: 1 }), l(s, { "label-class-name": "my-all-label", label: "机床名称" }, { default: a(() => [l(o, { prop: "machineToolName" }, { default: a(() => {
      var e;
      return [c("span", null, f(((e = r.currentRow) == null ? void 0 : e.machineToolName) || "-"), 1)];
    }), _: 1 })]), _: 1 }), l(s, { "label-class-name": "my-all-label", label: "零件类型" }, { default: a(() => [l(o, { prop: "parType" }, { default: a(() => {
      var e;
      return [c("span", null, f(w(A).VL[(e = r.currentRow) == null ? void 0 : e.partType] || "-"), 1)];
    }), _: 1 })]), _: 1 }), l(s, { "label-class-name": "my-all-label my-label ", label: "完成日期" }, { default: a(() => [l(o, { prop: "askCompleteTime" }, { default: a(() => [l(p, { modelValue: d.value.askCompleteTime, "onUpdate:modelValue": t[0] || (t[0] = (e) => d.value.askCompleteTime = e), placeholder: "选择完成日期", class: "input-border-none", size: "default", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} }, W = U(H, [["__scopeId", "data-v-5d671e97"]]);
export {
  W as default
};
