import { ref as u } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as M } from "vue";
import { createVNode as a } from "vue";
import { withCtx as l } from "vue";
import { unref as c } from "vue";
import { createTextVNode as k } from "vue";
import { createElementVNode as i } from "vue";
import { withDirectives as I } from "vue";
import { createBlock as E } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as G } from "vue";
import { isRef as O } from "vue";
import { Fragment as P } from "vue";
import { ElNotification as X } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { ElSwitch as J } from "element-plus";
import { vLoading as K } from "element-plus";
import { _ as Q, u as W, lX as Y } from "../../../../../../shared/runtime.js";
import { g as Z, c as ee } from "../../../../../../modules/project-data-5e9d497a.js";
import { s as te } from "../../../../../../modules/scheduling-2b0c95c3.js";
import ae from "./machine-dialog/index.vue.js";
import "../../../../../../modules/machine-10301ee2.js";
const le = { class: "flex-rss" }, oe = { __name: "index", props: { visible: { type: Boolean, required: true }, detailData: { type: Object } }, emits: ["update:visible", "colesHook"], setup(N, { emit: L }) {
  const d = N, y = L, { visible: w, handleClose: C } = W({ emit: y, props: d, field: "visible", closeHook: j, showHook: B }), S = u([]), m = u(false), V = u(""), f = u(false), h = u(false), _ = u(""), x = u();
  function B() {
    d.detailData && (V.value = d.detailData.cutMachine.machineName, v());
  }
  function j() {
    y("colesHook");
  }
  async function v() {
    f.value = true;
    try {
      const { content: o } = await Z({ mac: d.detailData.cutMachine.mac });
      o.forEach((t) => {
        t.plateState === "5" ? t.State = false : t.State = true;
      }), S.value = o;
    } catch (o) {
      console.log("钢板清单页面接口报错", o);
    }
    f.value = false;
  }
  function F(o) {
    x.value = o, _.value = o.mac, m.value = true;
  }
  function H(o) {
    console.log(o);
  }
  async function R(o) {
    h.value = true;
    try {
      const t = [o.id];
      let r = "";
      o.plateState === "5" ? r = await ee(t) : r = await te(t), X({ title: "更改状态成功", message: r, type: "success" }), v();
    } catch (t) {
      console.log(t);
    }
    h.value = false;
  }
  function T(o) {
    _.value = o.mac;
  }
  function U() {
    m.value = false, v();
  }
  return (o, t) => {
    const r = g("common-button"), n = A, z = J, $ = g("common-table"), q = g("common-dialog"), D = K;
    return b(), M(P, null, [a(q, { title: V.value, width: "73%", "show-close": false, "close-on-click-modal": false, modelValue: c(w), "onUpdate:modelValue": t[0] || (t[0] = (e) => O(w) ? w.value = e : null), "before-close": c(C) }, { titleRight: l(() => [a(r, { size: "default", onClick: c(C) }, { default: l(() => t[2] || (t[2] = [k("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])]), default: l(() => [i("div", le, [I((b(), E($, { "row-key": "id", ref: "tableRef", "max-height": 500, style: { width: "100%" }, data: S.value }, { default: l(() => [a(n, { label: "序号", type: "index", align: "center", width: "60" }), a(n, { key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "所属项目", "min-width": "80" }, { default: l((e) => [i("span", null, s(e.row.projectName), 1)]), _: 1 }), a(n, { key: "cutInstructionId", prop: "cutInstructionId", "show-overflow-tooltip": true, label: "指令号", "min-width": "100" }, { default: l((e) => [i("span", null, s(e.row.cutInstructionId), 1)]), _: 1 }), a(n, { key: "material", align: "center", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "45" }, { default: l((e) => [i("span", null, s(e.row.material), 1)]), _: 1 }), a(n, { key: "thick", prop: "thick", "show-overflow-tooltip": true, label: "厚度（mm）", "min-width": "55" }, { default: l((e) => [i("span", null, s(e.row.thick), 1)]), _: 1 }), a(n, { key: "width", prop: "width", "show-overflow-tooltip": true, label: "宽度（mm）", "min-width": "55" }, { default: l((e) => [i("span", null, s(e.row.width), 1)]), _: 1 }), a(n, { key: "length", prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "55" }, { default: l((e) => [i("span", null, s(e.row.length), 1)]), _: 1 }), a(n, { key: "weight", prop: "weight", "show-overflow-tooltip": true, label: "单重（kg）", "min-width": "55" }, { default: l((e) => [i("span", null, s(e.row.weight), 1)]), _: 1 }), a(n, { key: "weight", prop: "weight", "show-overflow-tooltip": true, label: "总重（kg）", "min-width": "55" }, { default: l((e) => [i("span", null, s(e.row.weight), 1)]), _: 1 }), a(n, { key: "plateState", prop: "plateState", "show-overflow-tooltip": true, label: "状态", "min-width": "55" }, { default: l((e) => [i("span", null, s(c(Y).VL[e.row.plateState]), 1)]), _: 1 }), a(n, { align: "center", label: "暂停切割", "min-width": "60" }, { default: l((e) => [I(a(z, { "active-color": "#409EFF", "inactive-color": "#F56C6C", modelValue: e.row.State, "onUpdate:modelValue": (p) => e.row.State = p, onChange: (p) => R(e.row), disabled: !(e.row.plateState === "1" || e.row.plateState === "0" || e.row.plateState === "2" || e.row.plateState === "5") }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange", "disabled"]), [[D, h.value]])]), _: 1 }), a(n, { align: "center", label: "操作", width: "180px" }, { default: l((e) => [a(r, { type: "danger", size: "default", onClick: (p) => H(e.row) }, { default: l(() => t[3] || (t[3] = [k("删除")])), _: 2, __: [3] }, 1032, ["onClick"]), e.row.plateState === "1" ? (b(), E(r, { key: 0, type: "warning", size: "default", onClick: (p) => F(e.row) }, { default: l(() => t[4] || (t[4] = [k(" 协同 ")])), _: 2, __: [4] }, 1032, ["onClick"])) : G("", true)]), _: 1 })]), _: 1 }, 8, ["data"])), [[D, f.value]])])]), _: 1 }, 8, ["title", "modelValue", "before-close"]), a(c(ae), { onEndEvent: U, selectLineId: _.value, "detail-data": x.value, visible: m.value, "onUpdate:visible": t[1] || (t[1] = (e) => m.value = e), onChange: T, isSingle: "" }, null, 8, ["selectLineId", "detail-data", "visible"])], 64);
  };
} }, de = Q(oe, [["__scopeId", "data-v-c9b0ab5e"]]);
export {
  de as default
};
