import { ref as _ } from "vue";
import { computed as se } from "vue";
import { watch as ne } from "vue";
import { nextTick as ie } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as v } from "vue";
import { createBlock as F } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as P } from "vue";
import { createElementBlock as T } from "vue";
import { createCommentVNode as H } from "vue";
import { inject as ue } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as M } from "vue";
import { unref as C } from "vue";
import { Fragment as D } from "vue";
import { renderList as K } from "vue";
import { normalizeClass as z } from "vue";
import { withModifiers as N } from "vue";
import { isRef as re } from "vue";
import { ElNotification as de } from "element-plus";
import { ElFormItem as me } from "element-plus";
import { ElCheckbox as pe } from "element-plus";
import { Top as ce } from "@element-plus/icons-vue";
import { ElIcon as fe } from "element-plus";
import { Bottom as ve } from "@element-plus/icons-vue";
import { Plus as _e } from "@element-plus/icons-vue";
import { Minus as be } from "@element-plus/icons-vue";
import { ElTimePicker as ge } from "element-plus";
import { ElCheckboxGroup as Ve } from "element-plus";
import { ElForm as he } from "element-plus";
import { j as ye, k as Te } from "../../../../../../modules/inspection-config-a69d9e2f.js";
import { mP as Le, i as ke, b as U, ai as we, _ as Ce, u as Be, au as Se, V as j, gA as Ee, mN as Ie, gB as Ne } from "../../../../../../shared/runtime.js";
const Ue = { class: "customize-option-item" }, Pe = { class: "flex-rsc label" }, $e = { key: 0, class: "extra-label" }, Ae = { key: 1, class: "extra-label" }, xe = { __name: "user-select", props: { modelValue: { type: [Number, String, Array] }, showDept: { type: Boolean, default: false }, showPhone: { type: Boolean, default: true }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, filterable: { type: Boolean, default: true }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择人员" } }, emits: ["change", "info-change", "update:modelValue"], setup(S, { emit: $ }) {
  const b = $, s = S, m = _(), y = _([]), g = _({}), L = _(false), V = se(() => y.value);
  ne(() => s.modelValue, (r) => {
    m.value = r;
  }, { immediate: true }), k();
  async function k() {
    y.value = [], g.value = {};
    try {
      L.value = false;
      const { content: r } = await Le();
      y.value = r, g.value = r.reduce((o, f) => (o[f.id] = f, o), {}), A();
    } catch (r) {
      console.log(r);
    } finally {
      L.value = true;
    }
  }
  function e(r) {
    let o = r;
    U(o) && (o = void 0);
    const f = !we(o, s.modelValue), p = U(o) && U(s.modelValue);
    f && !p && (b("update:modelValue", o), b("change", o), E(o, s.modelValue));
  }
  function E(r, o) {
    const f = r ? g.value[r] : null, p = o ? g.value[o] : null;
    b("info-change", f, p);
  }
  function A() {
    ke(m.value) ? E(m.value) : x();
  }
  function x() {
    ie(() => {
      if (!(U(V.value) || m.value) && s.default) {
        m.value = V.value[0].id, e(m.value);
        return;
      }
    });
  }
  return (r, o) => {
    const f = B("common-select");
    return v(), F(f, { modelValue: m.value, "onUpdate:modelValue": o[0] || (o[0] = (p) => m.value = p), size: s.size, disabled: s.disabled, multiple: s.multiple, "collapse-tags": s.collapseTags, loading: !L.value, clearable: s.clearable, filterable: s.filterable, placeholder: s.placeholder, options: V.value, onChange: e }, { view: u(({ data: p }) => [d("span", Ue, [d("span", Pe, [d("span", null, P(p.name), 1)]), d("span", null, [s.showDept ? (v(), T("span", $e, [o[1] || (o[1] = d("span", { class: "title" }, "部门：", -1)), d("span", null, P(p.deptName), 1)])) : H("", true), s.showPhone ? (v(), T("span", Ae, [o[2] || (o[2] = d("span", { class: "title" }, "手机号：", -1)), d("span", null, P(p.phone), 1)])) : H("", true)])])]), _: 1 }, 8, ["modelValue", "size", "disabled", "multiple", "collapse-tags", "loading", "clearable", "filterable", "placeholder", "options"]);
  };
} };
const De = ["onClick"], ze = ["onClick"], je = ["onClick"], Fe = ["onClick"], He = { class: "flex-rbc", style: { width: "100%" } }, qe = { __name: "user-line-dlg", props: { visible: { type: Boolean, default: false }, isEdit: { type: Boolean, default: false }, data: { type: Object, default: () => ({}) } }, emits: ["update:visible", "edit-success", "add-success"], setup(S, { emit: $ }) {
  const b = $, s = S, { visible: m, handleClose: y } = Be({ emit: b, props: s, field: "visible", showHook: x, closeHook: r }), g = { userId: void 0, isSort: false, pointList: [], startTime: void 0, endTime: void 0, patrolsTime: void 0, intervalTime: 0, avoidTimeArr: [], mandatoryInspection: Se.FALSE.V }, L = ue("selectPointList"), V = _(false), k = _(), e = _(j(g)), E = _({ mandatoryInspection: [{ required: true, message: "请选择强制巡检", trigger: "change" }], userId: [{ required: true, message: "请选择责任人", trigger: "change" }], patrolsTime: [{ required: true, message: "请输入巡检次数", trigger: "blur" }], startTime: [{ required: true, validator: A, trigger: ["change"] }], pointList: [{ required: true, validator: (t, l, i) => {
    console.log(l, l.length), !l.length || l.includes(null) ? i(new Error("请选择巡检点")) : i();
  }, message: "请选择巡检点", trigger: ["change"] }] });
  function A(t, l, i) {
    l ? e.value.endTime ? e.value.endTime && e.value.startTime > e.value.endTime ? i(new Error("开始时间不能大于结束时间")) : i() : i(new Error("请选择结束时间")) : i(new Error("请选择开始时间"));
  }
  function x() {
    if (s.isEdit) {
      e.value = j(s.data), e.value.avoidTimeArr = Ee(e.value.avoidTime), e.value.isSort = !!e.value.isSort;
      let t = e.value.inspectionList;
      e.value.isSort && (t = t.sort((l, i) => l.sortNumber - i.sortNumber)), e.value.pointList = t.map((l) => l.id);
    } else e.value = j(g), q(-1);
  }
  function r() {
    var t;
    (t = k.value) == null || t.clearValidate();
  }
  function o(t) {
    const l = [];
    for (let i = 0; i < e.value.pointList.length; i++) i !== t && l.push(e.value.pointList[i]);
    return l;
  }
  function f(t) {
    if (t === 0) return;
    const l = e.value.pointList[t];
    e.value.pointList.splice(t, 1), e.value.pointList.splice(t - 1, 0, l);
  }
  function p(t) {
    if (t === e.value.pointList.length - 1) return;
    const l = e.value.pointList[t];
    e.value.pointList.splice(t, 1), e.value.pointList.splice(t + 1, 0, l);
  }
  function q(t) {
    e.value.pointList.splice(t + 1, 0, null);
  }
  function J(t) {
    t === 0 && e.value.pointList.length === 1 || e.value.pointList.splice(t, 1);
  }
  async function Q() {
    try {
      if (!await k.value.validate()) return;
      V.value = true, e.value.projectInspectionDTOS = e.value.pointList.map((l, i) => ({ id: l, sortNumber: e.value.isSort ? i + 1 : void 0 })), s.isEdit ? await ye({ id: s.data.id, ...e.value, isSort: e.value.isSort ? 1 : 0 }) : (await Te({ ...e.value, isSort: e.value.isSort ? 1 : 0 }), b("add-success")), de({ title: `${s.isEdit ? "修改" : "创建"}巡检配置成功`, type: "success", duration: 2500 }), b("edit-success"), y();
    } catch (t) {
      console.error(t);
    } finally {
      V.value = false;
    }
  }
  function W(t) {
    e.value.avoidTime = Ne(t);
  }
  return (t, l) => {
    const i = B("common-button"), h = me, R = pe, X = B("common-select"), Y = ce, I = fe, Z = ve, ee = _e, le = be, O = ge, G = B("common-input-number"), te = Ve, ae = he, oe = B("common-dialog");
    return v(), F(oe, { title: `巡检配置${S.isEdit ? "修改" : "创建"}`, modelValue: C(m), "onUpdate:modelValue": l[7] || (l[7] = (n) => re(m) ? m.value = n : null), "close-on-click-modal": false, width: "500px", "before-close": C(y) }, { titleRight: u(() => [a(i, { type: "primary", loading: V.value, onClick: Q }, { default: u(() => l[8] || (l[8] = [M(" 保 存 ")])), _: 1, __: [8] }, 8, ["loading"])]), default: u(() => [a(ae, { ref_key: "formRef", ref: k, model: e.value, rules: E.value, "label-width": "140px" }, { default: u(() => [a(h, { label: "责任人", prop: "userId" }, { default: u(() => [a(C(xe), { modelValue: e.value.userId, "onUpdate:modelValue": l[0] || (l[0] = (n) => e.value.userId = n), placeholder: "请选择责任人", style: { width: "100%" }, clearable: "" }, null, 8, ["modelValue"])]), _: 1 }), a(h, { label: "巡检设定", prop: "isSort" }, { default: u(() => [a(R, { modelValue: e.value.isSort, "onUpdate:modelValue": l[1] || (l[1] = (n) => e.value.isSort = n), label: "是否需要排序", border: "" }, null, 8, ["modelValue"])]), _: 1 }), a(h, { label: "巡检路线设定", prop: "pointList" }, { default: u(() => [(v(true), T(D, null, K(e.value.pointList, (n, c) => (v(), T("div", { class: "flex-rbc line-item", key: c }, [a(X, { modelValue: e.value.pointList[c], "onUpdate:modelValue": (w) => e.value.pointList[c] = w, options: C(L), disabledVal: o(c), type: "other", clearable: "", style: { flex: "1" }, placeholder: "请选择巡检点" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabledVal"]), e.value.isSort ? (v(), T(D, { key: 0 }, [d("div", { class: z(["up-btn", c === 0 ? "btn-disabled" : ""]), onClick: N((w) => f(c), ["stop"]) }, [a(I, null, { default: u(() => [a(Y)]), _: 1 })], 10, De), d("div", { class: z(["down-btn", c === e.value.pointList.length - 1 ? "btn-disabled" : ""]), onClick: N((w) => p(c), ["stop"]) }, [a(I, null, { default: u(() => [a(Z)]), _: 1 })], 10, ze)], 64)) : H("", true), d("div", { class: "add-btn", onClick: N((w) => q(c), ["stop"]) }, [a(I, null, { default: u(() => [a(ee)]), _: 1 })], 8, je), d("div", { class: z(["del-btn", c === 0 && e.value.pointList.length === 1 ? "btn-disabled" : ""]), onClick: N((w) => J(c), ["stop"]) }, [a(I, null, { default: u(() => [a(le)]), _: 1 })], 10, Fe)]))), 128))]), _: 1 }), a(h, { label: "开始到结束", prop: "startTime" }, { default: u(() => [d("div", He, [a(O, { modelValue: e.value.startTime, "onUpdate:modelValue": l[2] || (l[2] = (n) => e.value.startTime = n), placeholder: "请选择时间", format: "HH:mm", "value-format": "x", style: { width: "150px" } }, null, 8, ["modelValue"]), l[9] || (l[9] = d("span", null, " ~ ", -1)), a(O, { modelValue: e.value.endTime, "onUpdate:modelValue": l[3] || (l[3] = (n) => e.value.endTime = n), placeholder: "请选择时间", format: "HH:mm", "value-format": "x", style: { width: "150px" } }, null, 8, ["modelValue"])])]), _: 1 }), a(h, { label: "巡检次数(次/天)", prop: "patrolsTime" }, { default: u(() => [a(G, { modelValue: e.value.patrolsTime, "onUpdate:modelValue": l[4] || (l[4] = (n) => e.value.patrolsTime = n), min: 0, max: 9999999999, step: 1, precision: 0, controls: false, clearable: "", style: { width: "100%" }, placeholder: "巡检次数" }, null, 8, ["modelValue"])]), _: 1 }), a(h, { label: "巡检间隔时间(分钟)", prop: "intervalTime" }, { default: u(() => [a(G, { modelValue: e.value.intervalTime, "onUpdate:modelValue": l[5] || (l[5] = (n) => e.value.intervalTime = n), min: 0, max: 9999999999, step: 1, precision: 0, controls: false, clearable: "", style: { width: "100%" }, placeholder: "间隔时间" }, null, 8, ["modelValue"])]), _: 1 }), a(h, { label: "避开周末", prop: "avoidTimeArr" }, { default: u(() => [a(te, { modelValue: e.value.avoidTimeArr, "onUpdate:modelValue": l[6] || (l[6] = (n) => e.value.avoidTimeArr = n), onChange: W }, { default: u(() => [(v(true), T(D, null, K(C(Ie).ENUM, (n) => (v(), F(R, { key: n.V, label: n.V }, { default: u(() => [M(P(n.L), 1)]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "rules"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, Je = Ce(qe, [["__scopeId", "data-v-c4600164"]]);
export {
  Je as default
};
