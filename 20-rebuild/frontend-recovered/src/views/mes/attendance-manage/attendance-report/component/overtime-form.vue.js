import { ref as d } from "vue";
import { inject as R } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as W } from "vue";
import { createBlock as H } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as s } from "vue";
import { unref as v } from "vue";
import { isRef as L } from "vue";
import { ElNotification as B } from "element-plus";
import { ElFormItem as M } from "element-plus";
import { ElDatePicker as N } from "element-plus";
import { ElRadio as z } from "element-plus";
import { ElRadioGroup as j } from "element-plus";
import { ElForm as F } from "element-plus";
import { l as O, m as S, n as G } from "../../../../../modules/attendance-report-ce8c4447.js";
import { u as P } from "../../../../../shared/runtime.js";
const X = { __name: "overtime-form", props: { visible: { type: Boolean, default: false }, overConfigId: { type: [String, Number], default: null } }, emits: ["update:visible", "success"], setup(T, { emit: k }) {
  const g = k, u = T, { visible: m, handleClose: b } = P({ emit: g, props: u, field: "visible", showHook: x }), c = d(), l = d({ departmentId: void 0, attendanceDate: void 0, rosterIds: [], overtimeClosingTime: void 0, overtimeWorkingTime: void 0, isCanDelay: false, isCanEarly: false }), _ = d([]), p = d(false), D = R("deptList"), w = { departmentId: [{ required: true, message: "请选择部门", trigger: "blur" }], attendanceDate: [{ required: true, message: "请选择日期", trigger: "blur" }], rosterIds: [{ required: true, message: "请选择人员", trigger: "blur" }], overtimeWorkingTime: [{ required: true, message: "请选择开始时间", trigger: "blur" }], overtimeClosingTime: [{ required: true, message: "请选择结束时间", trigger: "blur" }], isCanDelay: [{ required: true, message: "请选择是否允许迟到", trigger: "blur" }], isCanEarly: [{ required: true, message: "请选择是否允许早退", trigger: "blur" }] };
  function x() {
    u.overConfigId ? O({ overConfigId: u.overConfigId }).then(async (i) => {
      await y(i.departmentId), l.value = i;
    }) : l.value = {};
  }
  async function y(i) {
    const e = await S({ deptId: i });
    _.value = e;
  }
  async function E() {
    if (await c.value.validate()) {
      p.value = true;
      try {
        await G(l.value), B({ title: "考勤设置保存成功", type: "success", duration: 2500 }), b(), g("success");
      } catch (e) {
        console.log(e);
      } finally {
        p.value = false;
      }
    }
  }
  return (i, e) => {
    const Y = f("common-button"), C = f("common-select"), r = M, V = N, n = z, I = j, q = F, U = f("common-dialog");
    return W(), H(U, { title: "加班考勤设置", modelValue: v(m), "onUpdate:modelValue": e[6] || (e[6] = (a) => L(m) ? m.value = a : null), width: "500px", "close-on-click-modal": false, "before-close": v(b) }, { titleRight: o(() => [t(Y, { size: "mini", loading: p.value, type: "success", onClick: E }, { default: o(() => e[7] || (e[7] = [s("保存")])), _: 1, __: [7] }, 8, ["loading"])]), default: o(() => [t(q, { ref_key: "formRef", ref: c, model: l.value, rules: w, size: "small", "label-width": "135px" }, { default: o(() => [t(r, { label: "选择部门", prop: "departmentId" }, { default: o(() => [t(C, { modelValue: l.value.departmentId, "onUpdate:modelValue": e[0] || (e[0] = (a) => l.value.departmentId = a), options: v(D), type: "other", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", clearable: "", filterable: "", style: { width: "270px" }, placeholder: "选择部门", onChange: y }, null, 8, ["modelValue", "options"])]), _: 1 }), t(r, { label: "创建人员", prop: "rosterIds" }, { default: o(() => [t(C, { modelValue: l.value.rosterIds, "onUpdate:modelValue": e[1] || (e[1] = (a) => l.value.rosterIds = a), options: _.value, type: "other", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", clearable: "", filterable: "", multiple: "", style: { width: "270px" }, placeholder: "选择人员" }, null, 8, ["modelValue", "options"])]), _: 1 }), t(r, { label: "开始时间", prop: "overtimeWorkingTime" }, { default: o(() => [t(V, { modelValue: l.value.overtimeWorkingTime, "onUpdate:modelValue": e[2] || (e[2] = (a) => l.value.overtimeWorkingTime = a), format: "YYYY-MM-DD HH:mm", "disabled-date": (a) => l.value.overtimeClosingTime < a, type: "datetime", "value-format": "x", placeholder: "开始日期", style: { width: "270px" } }, null, 8, ["modelValue", "disabled-date"])]), _: 1 }), t(r, { label: "结束时间", prop: "overtimeClosingTime" }, { default: o(() => [t(V, { modelValue: l.value.overtimeClosingTime, "onUpdate:modelValue": e[3] || (e[3] = (a) => l.value.overtimeClosingTime = a), format: "YYYY-MM-DD HH:mm", "disabled-date": (a) => l.value.overtimeWorkingTime - 24 * 60 * 60 * 1e3 > a.getTime(), type: "datetime", "value-format": "x", placeholder: "结束日期", style: { width: "270px" } }, null, 8, ["modelValue", "disabled-date"])]), _: 1 }), t(r, { label: "是否允许迟到", prop: "isCanDelay" }, { default: o(() => [t(I, { modelValue: l.value.isCanDelay, "onUpdate:modelValue": e[4] || (e[4] = (a) => l.value.isCanDelay = a) }, { default: o(() => [t(n, { value: false, label: false }, { default: o(() => e[8] || (e[8] = [s("否")])), _: 1, __: [8] }), t(n, { value: true, label: true }, { default: o(() => e[9] || (e[9] = [s("是")])), _: 1, __: [9] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), t(r, { label: "是否允许早退", prop: "isCanEarly" }, { default: o(() => [t(I, { modelValue: l.value.isCanEarly, "onUpdate:modelValue": e[5] || (e[5] = (a) => l.value.isCanEarly = a) }, { default: o(() => [t(n, { value: false, label: false }, { default: o(() => e[10] || (e[10] = [s("否")])), _: 1, __: [10] }), t(n, { value: true, label: true }, { default: o(() => e[11] || (e[11] = [s("是")])), _: 1, __: [11] })]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  X as default
};
