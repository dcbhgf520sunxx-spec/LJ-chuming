import { ref as c } from "vue";
import { computed as R } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as V } from "vue";
import { createElementBlock as Y } from "vue";
import { createVNode as l } from "vue";
import { withCtx as o } from "vue";
import { createTextVNode as r } from "vue";
import { unref as _ } from "vue";
import { toDisplayString as y } from "vue";
import { createElementVNode as F } from "vue";
import { withDirectives as Q } from "vue";
import { createBlock as W } from "vue";
import { withModifiers as $ } from "vue";
import { isRef as J } from "vue";
import { Fragment as K } from "vue";
import { ElMessage as X } from "element-plus";
import { ElNotification as Z } from "element-plus";
import { ElButton as ee } from "element-plus";
import { ElDescriptionsItem as ae } from "element-plus";
import { ElDatePicker as te } from "element-plus";
import { ElDescriptions as le } from "element-plus";
import { ElTableColumn as ie } from "element-plus";
import { vLoading as oe } from "element-plus";
import { _ as ne, u as se, o as de, qT as ce, rm as re } from "../../../../../../shared/runtime.js";
import ue from "./drill-scheduling-dialog.vue.js";
const me = { __name: "produce-drawer", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => ({}) }, list: { type: Array, default: () => [] }, labelInfo: { type: Object, default: () => {
} }, machineList: { type: Array, default: () => [] } }, emits: ["update:visible", "close", "success", "handleDel", "handleBatchDel"], setup(d, { emit: T }) {
  const u = T, n = d, { visible: h, handleClose: b } = se({ emit: u, props: n, field: "visible", showHook: H }), { maxHeight: N } = de({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, h), v = c([]), B = c(false), m = c();
  c();
  const p = c(false), k = c(false), w = c({}), E = R(() => {
    const i = [];
    return n.list.map((e) => {
      i.push({ id: e.id, guid: e.guid, thick: e.thickness, width: e.plateWidth, length: e.plateHeight, quantity: e.amount, machineToolId: e.machineToolId, partQuantity: e.partAmount, material: e.material, childGuid: e.childGuid });
    }), { data: i, finishDate: m.value };
  });
  function L(i) {
    var e;
    return i > ((e = n.labelInfo) == null ? void 0 : e.artifactAskCompleteTime);
  }
  async function H() {
    m.value = n.labelInfo.artifactAskCompleteTime;
  }
  async function M() {
    var f;
    if (!m.value) {
      X.error("请选择完成日期");
      return;
    }
    let i = [];
    const e = [];
    n.list.map((t) => {
      e.push({ id: t.id, guid: t.guid, thick: t.thickness, width: t.plateWidth, length: t.plateHeight, quantity: t.amount, machineToolId: t.machineToolId, partQuantity: t.partAmount, material: t.material, childGuid: t.childGuid }), i = [...i, ...t.partList];
    });
    try {
      p.value = true;
      const t = await ce({ thick: String(Math.max(...i.map((I) => I.thick))), cutConfigId: (f = n.labelInfo) == null ? void 0 : f.downConfigId, partList: i });
      t != null && t.boolDrillEnum ? (k.value = true, w.value = t || {}) : (await re({ finishDate: m.value, jobId: n.labelInfo.jobId, workshop: n.labelInfo.workshopId, machinePartNestingCutJobParamList: e, machineTool: e[0].machineToolId }), Z({ title: "下发成功", type: "success", duration: 2e3 }), u("update:visible", false), b(), u("success"));
    } catch (t) {
      console.error(t);
    } finally {
      p.value = false;
    }
  }
  const q = (i) => {
    v.value = i;
  };
  function z(i, e) {
    u("handleDel", { row: i, id: e });
  }
  const P = () => {
    u("handleBatchDel", { list: v.value });
  };
  function S() {
    u("success"), b();
  }
  return (i, e) => {
    var C;
    const f = ee, t = ae, I = te, A = le, D = g("common-button"), s = ie, j = g("common-select"), O = g("common-table"), U = g("common-drawer"), G = oe;
    return V(), Y(K, null, [l(U, { title: "切割任务下发", modelValue: _(h), "onUpdate:modelValue": e[1] || (e[1] = (a) => J(h) ? h.value = a : null), "show-close": false, "before-close": _(b), size: "70%", closeOnClickModal: false }, { titleRight: o(() => [l(f, { type: "success", size: "default", onClick: M, loading: p.value, disabled: !d.list.length }, { default: o(() => e[3] || (e[3] = [r("任务下发")])), _: 1, __: [3] }, 8, ["loading", "disabled"]), l(f, { size: "default", onClick: _(b), loading: p.value }, { default: o(() => e[4] || (e[4] = [r("取消")])), _: 1, __: [4] }, 8, ["onClick", "loading"])]), content: o(() => [l(A, { column: 3, data: i.nestingDocumentList, border: "", class: "nesting-document" }, { default: o(() => [l(t, { label: "工单号", span: "3" }, { default: o(() => {
      var a;
      return [r(y((a = d.labelInfo) == null ? void 0 : a.label), 1)];
    }), _: 1 }), l(t, { label: "车间" }, { default: o(() => {
      var a;
      return [r(y((a = d.labelInfo) == null ? void 0 : a.workshopName), 1)];
    }), _: 1 }), l(t, { align: "center", label: "班组" }, { default: o(() => {
      var a;
      return [r(y((a = d.labelInfo) == null ? void 0 : a.teamName), 1)];
    }), _: 1 }), l(t, { align: "center" }, { label: o(() => e[5] || (e[5] = [F("div", { class: "label-require" }, "完成日期", -1)])), default: o(() => [l(I, { modelValue: m.value, "onUpdate:modelValue": e[0] || (e[0] = (a) => m.value = a), type: "date", size: "default", class: "date-item filter-item", style: { width: "100%" }, placeholder: "选择完成日期", clearable: false, format: "YYYY-MM-DD", "value-format": "x", disabled: p.value, "disabled-date": L }, null, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 }, 8, ["data"]), l(D, { type: "danger", icon: "el-icon-delete", size: "default", style: { float: "right", margin: "10px 0" }, onClick: P }, { default: o(() => e[6] || (e[6] = [r(" 批量删除 ")])), _: 1, __: [6] }), Q((V(), W(O, { "return-source-data": "", data: d.list, "max-height": _(N), style: { width: "100%", "margin-top": "15px" }, onSelectionChange: q }, { default: o(() => [l(s, { type: "selection", align: "center", width: "50" }), l(s, { type: "index", label: "序号", align: "center", width: "50" }), l(s, { key: "machineId", prop: "machineId", label: "机床", align: "center" }, { default: o(({ row: a }) => [l(j, { modelValue: a.machineToolId, "onUpdate:modelValue": (x) => a.machineToolId = x, options: d.machineList, disabled: true, "data-structure": { key: "id", label: "name", value: "id" }, placeholder: "请选择机床", style: { width: "100%" }, size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 1 }), l(s, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "切割方式", align: "center" }, { default: o(({ row: a }) => [r(y(a == null ? void 0 : a.deviceName), 1)]), _: 1 }), l(s, { key: "childOrderNumber", prop: "childOrderNumber", label: "ID号", align: "center", "min-width": "150", "show-overflow-tooltip": true }), l(s, { key: "thickness", prop: "thickness", label: "厚度（mm）", align: "center" }), l(s, { key: "amount", prop: "amount", label: "数量（张）", align: "center" }), l(s, { key: "material", prop: "material", label: "材质", align: "center" }), l(s, { "show-overflow-tooltip": true, label: "操作", width: "80", align: "center" }, { default: o(({ row: a }) => [l(D, { type: "danger", icon: "el-icon-delete", size: "default", onClick: $((x) => z(a, a.id), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[G, B.value]])]), _: 1 }, 8, ["modelValue", "before-close"]), l(ue, { visible: k.value, "onUpdate:visible": e[2] || (e[2] = (a) => k.value = a), "drill-data": w.value, onSuccess: S, labelInfo: d.labelInfo, queryParams: E.value, schedulingId: (C = n.partList) == null ? void 0 : C.id }, null, 8, ["visible", "drill-data", "labelInfo", "queryParams", "schedulingId"])], 64);
  };
} }, be = ne(me, [["__scopeId", "data-v-5ed35773"]]);
export {
  be as default
};
