import { ref as d } from "vue";
import { watch as P } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as q } from "vue";
import { createBlock as M } from "vue";
import { withCtx as t } from "vue";
import { createVNode as e } from "vue";
import { withModifiers as j } from "vue";
import { createTextVNode as k } from "vue";
import { createElementVNode as c } from "vue";
import { toDisplayString as m } from "vue";
import { unref as u } from "vue";
import { isRef as A } from "vue";
import { ElMessage as H } from "element-plus";
import { ElFormItem as O } from "element-plus";
import { ElDescriptionsItem as G } from "element-plus";
import { ElDatePicker as J } from "element-plus";
import { ElDescriptions as K } from "element-plus";
import { ElForm as Q } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { ElTag as X } from "element-plus";
import { f as Y } from "../../../../../modules/cloud-cutting-assistant-43dc84e4.js";
import { _ as Z, u as $, qw as N, qx as V, qy as E } from "../../../../../shared/runtime.js";
const ee = { class: "form" }, ae = { __name: "batch-task-issue-form", props: { visible: { type: Boolean, default: false }, selections: { type: Array, default: () => [] }, maxHeight: { type: [Number, String], default: void 0 }, currentTreeData: { type: Object, default: () => {
} }, machineList: { type: Array, default: () => [] } }, emits: ["success", "update:visible", "delChange"], setup(f, { emit: F }) {
  const x = F, i = d([]), _ = d(), h = d(false), p = f, D = d([["importTime", ["parse-time", "{y}-{m}-{d}"]], ["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]], ["cutSendTime", ["parse-time", "{y}-{m}-{d}"]]]), b = d({ askCompleteTime: void 0 }), { visible: T, handleClose: S } = $({ emit: x, props: p, field: "visible" });
  P(() => p.visible, async (v) => {
    var o, n;
    v && (await ((o = _.value) == null ? void 0 : o.resetFields()), await ((n = _.value) == null ? void 0 : n.clearValidate()), i.value = p.selections, i.value.forEach((l) => {
      var r, y;
      l.machineToolName = (y = (r = p.machineList) == null ? void 0 : r.find((w) => w.id === l.machineToolId)) == null ? void 0 : y.name;
    }), console.log(p.currentTreeData, i.value, "currentTreeData"));
  }, { immediate: true });
  const L = { askCompleteTime: [{ required: true, message: "请选择完成日期", trigger: "change" }] };
  async function R() {
    var o;
    if (await _.value.validate()) try {
      h.value = true;
      const n = (o = i.value) == null ? void 0 : o.map((l) => ({ askCompleteTime: b.value.askCompleteTime, cloudcutId: l.cloudcutId, id: l.id, filePath: l.filePath, fileName: l.fileName, machineToolId: l.machineToolId }));
      await Y(n), H.success("下发成功"), S(), x("success");
    } catch (n) {
      console.log(n, "提交失败");
    } finally {
      h.value = false;
    }
  }
  return (v, o) => {
    const n = g("common-button"), l = O, r = G, y = J, w = K, z = Q, s = W, C = X, U = g("common-table"), B = g("common-dialog");
    return q(), M(B, { title: "数控任务下发", visible: u(T), "onUpdate:visible": o[1] || (o[1] = (a) => A(T) ? T.value = a : null), "before-close": u(S), "append-to-body": true, "close-on-click-modal": false, width: "1400px" }, { titleRight: t(() => [e(n, { size: "default", class: "filter-item", type: "primary", submitLoading: h.value, onClick: j(R, ["stop"]) }, { default: t(() => o[2] || (o[2] = [k(" 确 认 ")])), _: 1, __: [2] }, 8, ["submitLoading"])]), default: t(() => [c("div", ee, [e(z, { ref_key: "formRef", ref: _, model: b.value, rules: L, size: "default", class: "demo-form" }, { default: t(() => [e(w, { border: "", column: 1 }, { default: t(() => [e(r, { "label-class-name": "my-all-label", label: "工单号" }, { default: t(() => [e(l, { prop: "orderId" }, { default: t(() => {
      var a;
      return [c("span", null, m(((a = f.currentTreeData) == null ? void 0 : a.name) || "-"), 1)];
    }), _: 1 })]), _: 1 }), e(r, { "label-class-name": "my-all-label", label: "车间" }, { default: t(() => [e(l, { prop: "workshopId" }, { default: t(() => {
      var a;
      return [c("span", null, m(((a = f.currentTreeData) == null ? void 0 : a.workshopName) || "-"), 1)];
    }), _: 1 })]), _: 1 }), e(r, { "label-class-name": "my-all-label", label: "机床名称" }, { default: t(() => [e(l, { prop: "cncMachine" }, { default: t(() => {
      var a;
      return [c("span", null, m(i.value.length ? (a = i.value[0]) == null ? void 0 : a.machineToolName : "-"), 1)];
    }), _: 1 })]), _: 1 }), e(r, { "label-class-name": "my-all-label", label: "零件类型" }, { default: t(() => [e(l, { prop: "partType" }, { default: t(() => {
      var a;
      return [c("span", null, m(i.value.length ? u(N).VL[(a = i.value[0]) == null ? void 0 : a.partType] : "-"), 1)];
    }), _: 1 })]), _: 1 }), e(r, { "label-class-name": "my-all-label my-label ", label: "完成日期" }, { default: t(() => [e(l, { prop: "askCompleteTime" }, { default: t(() => [e(y, { modelValue: b.value.askCompleteTime, "onUpdate:modelValue": o[0] || (o[0] = (a) => b.value.askCompleteTime = a), placeholder: "选择完成日期", class: "input-border-none", size: "default", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"]), e(U, { ref: "tableRef", data: i.value, "empty-text": "暂无数据", "max-height": f.maxHeight, dataFormat: D.value, style: { width: "100%", "margin-top": "10px" }, "row-key": "id" }, { default: t(() => [e(s, { type: "index", key: "index", prop: "index", label: "序号", width: "55", align: "center" }), e(s, { key: "importTime", prop: "importTime", label: "导入日期", align: "center", "show-overflow-tooltip": true }), e(s, { key: "importUserName", prop: "importUserName", label: "导入人", align: "center", "show-overflow-tooltip": true }), e(s, { key: "fileName", prop: "fileName", "show-overflow-tooltip": true, label: "文件名称", align: "center", "min-width": "140px" }), e(s, { key: "partType", prop: "partType", align: "center", "show-overflow-tooltip": true, label: "零件类型" }, { default: t(({ row: { sourceRow: a } }) => [c("span", null, m(u(N).VL[a.partType]), 1)]), _: 1 }), e(s, { key: "machineToolId", prop: "machineToolId", label: "数控机床", align: "center", "show-overflow-tooltip": true, "min-width": "160px" }, { default: t(({ row: { sourceRow: a } }) => [c("span", null, m(a.machineToolName || "-"), 1)]), _: 1 }), e(s, { key: "issueUserName", prop: "issueUserName", label: "下发人", align: "center", "show-overflow-tooltip": true }), e(s, { key: "cutSendTime", prop: "cutSendTime", label: "下发日期", align: "center", "show-overflow-tooltip": true }), e(s, { key: "askCompleteTime", prop: "askCompleteTime", label: "完成日期", align: "center", "show-overflow-tooltip": true }), e(s, { key: "cutSendStatus", prop: "cutSendStatus", label: "下发状态", align: "center" }, { default: t(({ row: { sourceRow: a } }) => {
      var I;
      return [e(C, { type: (I = u(V).V[a.cutSendStatus]) == null ? void 0 : I.T, size: "default" }, { default: t(() => [k(m(u(V).VL[a.cutSendStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 }), e(s, { key: "cutStatus", prop: "cutStatus", label: "切割状态", align: "center" }, { default: t(({ row: { sourceRow: a } }) => [e(C, { type: u(E).V[a.cutStatus].T, size: "default" }, { default: t(() => [k(m(u(E).VL[a.cutStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "dataFormat"])])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} }, se = Z(ae, [["__scopeId", "data-v-6c18827a"]]);
export {
  se as default
};
