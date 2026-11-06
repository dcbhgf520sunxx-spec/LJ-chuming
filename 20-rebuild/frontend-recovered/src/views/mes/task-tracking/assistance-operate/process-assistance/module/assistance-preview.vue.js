import { ref as M } from "vue";
import { inject as L } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as i } from "vue";
import { createBlock as n } from "vue";
import { withCtx as l } from "vue";
import { unref as t } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as u } from "vue";
import { createVNode as r } from "vue";
import { createElementVNode as y } from "vue";
import { isRef as P } from "vue";
import { ElNotification as W } from "element-plus";
import { ElTag as j } from "element-plus";
import { ElTableColumn as S } from "element-plus";
import { s as D } from "../../../../../../modules/process-assistance-e91c5400.js";
import { u as U, o as z, rL as m } from "../../../../../../shared/runtime.js";
const J = { __name: "assistance-preview", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} }, list: { type: Array, default: () => [] } }, emits: ["update:visible", "success"], setup(g, { emit: V }) {
  const T = V, v = g, { visible: h, handleClose: x } = U({ emit: T, props: v, field: "visible" }), { maxHeight: C } = z({ mainBox: ".assistance-preview", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, h), H = M([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]]]), p = L("crud"), b = M(false);
  async function I() {
    try {
      b.value = true;
      const w = v.list.map((c) => ({ id: c.id, groupsId: c.groupsId }));
      await D({ assistList: w }), W({ title: "工序协同保存成功", type: "success", duration: 2500 }), x(), T("success");
    } catch (w) {
      console.log("保存工序协同报错", w);
    } finally {
      b.value = false;
    }
  }
  return (w, c) => {
    const E = j, q = _("common-button"), o = S, R = _("common-table"), B = _("common-dialog");
    return i(), n(B, { "custom-class": "assistance-preview", "append-to-body": "", "close-on-click-modal": false, title: "工序协同预览", modelValue: t(h), "onUpdate:modelValue": c[0] || (c[0] = (e) => P(h) ? h.value = e : null), width: "1300px", "before-close": t(x) }, { titleAfter: l(() => [t(p).query.taskTypeEnum !== t(m).MACHINE_PART.V ? (i(), n(E, { key: 0, effect: "plain" }, { default: l(() => {
      var e, a;
      return [k(" 原生产线：" + s((e = g.info.workshop) == null ? void 0 : e.name) + ">" + s((a = g.info.productionLine) == null ? void 0 : a.name), 1)];
    }), _: 1 })) : u("", true)]), titleRight: l(() => [r(q, { onClick: I, loading: b.value, size: "default", type: "primary" }, { default: l(() => c[1] || (c[1] = [k("保存")])), _: 1, __: [1] }, 8, ["loading"])]), default: l(() => [r(R, { data: g.list, "data-format": H.value, "max-height": t(C), style: { width: "100%" } }, { default: l(() => [r(o, { label: "序号", type: "index", align: "center", width: "60" }), t(p).query.taskTypeEnum !== t(m).MACHINE_PART.V ? (i(), n(o, { key: 0, prop: "areaName", "show-overflow-tooltip": true, label: "区域", "min-width": "100px", align: "center" })) : u("", true), t(p).query.taskTypeEnum === t(m).ASSEMBLE.V ? (i(), n(o, { key: 1, prop: "attributeType", "show-overflow-tooltip": true, label: "属性", width: "90", align: "center" }, { default: l(({ row: e }) => [r(E, { type: e.attributeType === "部件" ? "warning" : "success" }, { default: l(() => [k(s(e.attributeType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : u("", true), t(p).query.taskTypeEnum === t(m).MACHINE_PART.V ? (i(), n(o, { key: 2, prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", "min-width": "100px", align: "center" })) : u("", true), t(p).query.taskTypeEnum !== t(m).MACHINE_PART.V ? (i(), n(o, { key: 3, prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100px", align: "center" })) : u("", true), r(o, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "100px", align: "center" }), t(p).query.taskTypeEnum !== t(m).MACHINE_PART.V ? (i(), n(o, { key: 4, prop: "length", "show-overflow-tooltip": true, label: "长度(mm)", width: "100px", align: "center" })) : u("", true), r(o, { align: "center", prop: "totalTaskMete.quantity", "show-overflow-tooltip": true, label: "任务数（件）" }, { default: l(({ row: e }) => {
      var a;
      return [y("span", null, s(((a = e.totalTaskMete) == null ? void 0 : a.quantity) || 0), 1)];
    }), _: 1 }), r(o, { align: "center", prop: "totalTaskMete.netWeight", "show-overflow-tooltip": true, label: "任务总净重（kg）", width: "125px" }, { default: l(({ row: e }) => {
      var a;
      return [y("span", null, s(((a = e.totalTaskMete) == null ? void 0 : a.netWeight) || 0), 1)];
    }), _: 1 }), r(o, { align: "center", prop: "totalTaskMete.grossWeight", "show-overflow-tooltip": true, label: "任务总毛重（kg）", width: "125px" }, { default: l(({ row: e }) => {
      var a;
      return [y("span", null, s(((a = e.totalTaskMete) == null ? void 0 : a.grossWeight) || 0), 1)];
    }), _: 1 }), t(p).query.taskTypeEnum === t(m).MACHINE_PART.V ? (i(), n(o, { key: 5, align: "center", prop: "askCompleteTime", "show-overflow-tooltip": true, label: "计划完成日期", width: "120px" })) : u("", true), t(p).query.taskTypeEnum === t(m).MACHINE_PART.V ? (i(), n(o, { key: 6, prop: "group.name", "show-overflow-tooltip": true, label: "原生产组", "min-width": "160px" }, { default: l(({ row: e }) => {
      var a, d, f;
      return [y("span", null, s((a = e.workshop) == null ? void 0 : a.name) + ">" + s((d = e.productionLine) == null ? void 0 : d.name) + ">" + s((f = e.groups) == null ? void 0 : f.name), 1)];
    }), _: 1 })) : u("", true), r(o, { prop: "groupsName", "show-overflow-tooltip": true, label: "协同生产组", "min-width": "150" }, { default: l(({ row: e }) => {
      var a, d, f, N, A;
      return [y("span", null, s((d = (a = e.assistance) == null ? void 0 : a.workshop) == null ? void 0 : d.name) + ">" + s((N = (f = e.assistance) == null ? void 0 : f.productionLine) == null ? void 0 : N.name) + ">" + s((A = e.assistance) == null ? void 0 : A.groupsName), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  J as default
};
