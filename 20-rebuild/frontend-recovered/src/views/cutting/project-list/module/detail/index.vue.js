import { ref as u } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as x } from "vue";
import { createElementBlock as M } from "vue";
import { createVNode as a } from "vue";
import { withCtx as l } from "vue";
import { unref as d } from "vue";
import { createTextVNode as k } from "vue";
import { createElementVNode as i } from "vue";
import { withDirectives as I } from "vue";
import { createBlock as G } from "vue";
import { toDisplayString as s } from "vue";
import { isRef as H } from "vue";
import { Fragment as O } from "vue";
import { ElNotification as D } from "element-plus";
import { ElTableColumn as P } from "element-plus";
import { ElSwitch as X } from "element-plus";
import { vLoading as A } from "element-plus";
import { _ as J, u as K, lX as Q } from "../../../../../shared/runtime.js";
import { g as W, c as Y } from "../../../../../modules/project-data-5e9d497a.js";
import { s as Z } from "../../../../../modules/scheduling-2b0c95c3.js";
import ee from "./machine-dialog/index.vue.js";
import "../../../../../modules/machine-10301ee2.js";
const te = { class: "flex-rss" }, ae = { __name: "index", props: { visible: { type: Boolean, required: true }, detailData: { type: Object } }, emits: ["update:visible"], setup(E, { emit: N }) {
  const c = E, L = N, { visible: w, handleClose: y } = K({ emit: L, props: c, field: "visible", showHook: B }), S = u([]), m = u(false), C = u(""), f = u(false), h = u(false), _ = u(""), v = u();
  function B() {
    c.detailData && (C.value = c.detailData.cutMachine.machineName, g());
  }
  async function g() {
    f.value = true;
    try {
      const { content: o } = await W({ mac: c.detailData.cutMachine.mac });
      o.forEach((t) => {
        t.plateState === "5" ? t.State = true : t.State = false;
      }), S.value = o;
    } catch (o) {
      console.log("钢板清单页面接口报错", o);
    }
    f.value = false;
  }
  function j(o) {
    v.value = o, _.value = o.mac, m.value = true;
  }
  function R(o) {
    console.log(o);
  }
  async function T(o) {
    h.value = true;
    try {
      const t = [o.id];
      let r = "";
      o.plateState === "5" ? (r = await Y(t), D({ title: "更改状态成功", message: r, type: "success" })) : (r = await Z(t), D({ title: "更改状态成功", message: r, type: "success" }));
    } catch (t) {
      console.log(t);
    }
    h.value = false, g();
  }
  function U(o) {
    _.value = o.mac, v.value = o;
  }
  function z() {
    m.value = false, g();
  }
  return (o, t) => {
    const r = b("common-button"), n = P, $ = X, q = b("common-table"), F = b("common-dialog"), V = A;
    return x(), M(O, null, [a(F, { title: C.value, width: "73%", "show-close": false, "close-on-click-modal": false, modelValue: d(w), "onUpdate:modelValue": t[0] || (t[0] = (e) => H(w) ? w.value = e : null), "before-close": d(y) }, { titleRight: l(() => [a(r, { size: "default", onClick: d(y) }, { default: l(() => t[2] || (t[2] = [k("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])]), default: l(() => [i("div", te, [I((x(), G(q, { "row-key": "id", ref: "tableRef", "max-height": 500, style: { width: "100%" }, data: S.value }, { default: l(() => [a(n, { label: "序号", type: "index", align: "center", width: "60" }), a(n, { key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "所属项目", "min-width": "80" }, { default: l((e) => [i("span", null, s(e.row.projectName), 1)]), _: 1 }), a(n, { key: "cutInstructionId", prop: "cutInstructionId", "show-overflow-tooltip": true, label: "指令号", "min-width": "100" }, { default: l((e) => [i("span", null, s(e.row.cutInstructionId), 1)]), _: 1 }), a(n, { key: "material", align: "center", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "45" }, { default: l((e) => [i("span", null, s(e.row.material), 1)]), _: 1 }), a(n, { key: "thick", prop: "thick", "show-overflow-tooltip": true, label: "厚度（mm）", "min-width": "55" }, { default: l((e) => [i("span", null, s(e.row.thick), 1)]), _: 1 }), a(n, { key: "width", prop: "width", "show-overflow-tooltip": true, label: "宽度（mm）", "min-width": "55" }, { default: l((e) => [i("span", null, s(e.row.width), 1)]), _: 1 }), a(n, { key: "length", prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "55" }, { default: l((e) => [i("span", null, s(e.row.length), 1)]), _: 1 }), a(n, { key: "weight", prop: "weight", "show-overflow-tooltip": true, label: "单重（kg）", "min-width": "55" }, { default: l((e) => [i("span", null, s(e.row.weight), 1)]), _: 1 }), a(n, { key: "weight", prop: "weight", "show-overflow-tooltip": true, label: "总重（kg）", "min-width": "55" }, { default: l((e) => [i("span", null, s(e.row.weight), 1)]), _: 1 }), a(n, { key: "plateState", prop: "plateState", "show-overflow-tooltip": true, label: "状态", "min-width": "55" }, { default: l((e) => [i("span", null, s(d(Q).VL[e.row.plateState]), 1)]), _: 1 }), a(n, { align: "center", label: "暂停切割", "min-width": "60" }, { default: l((e) => [I(a($, { modelValue: e.row.State, "onUpdate:modelValue": (p) => e.row.State = p, onChange: (p) => T(e.row), disabled: !(e.row.plateState === "1" || e.row.plateState === "0" || e.row.plateState === "2" || e.row.plateState === "5") }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange", "disabled"]), [[V, h.value]])]), _: 1 }), a(n, { align: "center", label: "操作", "min-width": "80" }, { default: l((e) => [a(r, { type: "danger", size: "default", onClick: (p) => R(e.row) }, { default: l(() => t[3] || (t[3] = [k("删除")])), _: 2, __: [3] }, 1032, ["onClick"]), a(r, { type: "warning", size: "default", onClick: (p) => j(e.row) }, { default: l(() => t[4] || (t[4] = [k("协同")])), _: 2, __: [4] }, 1032, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data"])), [[V, f.value]])])]), _: 1 }, 8, ["title", "modelValue", "before-close"]), a(d(ee), { onEndEvent: z, selectLineId: _.value, "detail-data": v.value, visible: m.value, "onUpdate:visible": t[1] || (t[1] = (e) => m.value = e), onChange: U, isSingle: "" }, null, 8, ["selectLineId", "detail-data", "visible"])], 64);
  };
} }, ue = J(ae, [["__scopeId", "data-v-42232c44"]]);
export {
  ue as default
};
