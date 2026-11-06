import { ElMessage as ie } from "element-plus";
import { cloneDeep as re } from "lodash";
import { ref as _ } from "vue";
import { watch as de } from "vue";
import { computed as ue } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as E } from "vue";
import { createElementBlock as ce } from "vue";
import { createVNode as u } from "vue";
import { withCtx as m } from "vue";
import { createTextVNode as B } from "vue";
import { toDisplayString as R } from "vue";
import { unref as N } from "vue";
import { createElementVNode as I } from "vue";
import { createBlock as O } from "vue";
import { createCommentVNode as S } from "vue";
import { isRef as pe } from "vue";
import { Fragment as fe } from "vue";
import { ElNotification as me } from "element-plus";
import { ElTag as be } from "element-plus";
import { ElTableColumn as ge } from "element-plus";
import { ElCascader as he } from "element-plus";
import { ElForm as ve } from "element-plus";
import { s as ye } from "../../../../../../modules/process-assistance-e91c5400.js";
import { a$ as T, i as j, rM as we, b as q, _ as xe, u as _e, o as ke } from "../../../../../../shared/runtime.js";
import Ce from "./next-process-assist-dialog.vue.js";
function Le({ rules: e = {}, ditto: i = /* @__PURE__ */ new Map(), errorMsg: b = "请修正表格中标红的信息" }) {
  return { tableValidate: (n) => Ve(n, e, i, b), wrongCellMask: (n) => Re(n, e), cleanUpData: (n) => Ie(n, i) };
}
function Ve(e, i, b, n) {
  const a = W(i);
  let g = true, p = "请填写数据";
  if (!e || e && e.length > 0) {
    let k = true;
    for (const w in e) {
      const r = e[w];
      delete r.verify;
      const x = JSON.parse(JSON.stringify(r));
      if (delete x.uid, b.forEach((h, C) => {
        x[C] === h && delete x[C];
      }), !!T(x).some((h) => j(h))) {
        k && (b.forEach((h, C) => {
          r[C] === h && delete r[C];
        }), k = false), r.verify = {};
        for (const h in a) r.verify[h] = F(h, a[h], r), r.verify[h] || (g = false);
      }
    }
    g || (p = n);
  }
  return g || ie({ message: p, type: "error" }), { dealList: e, validResult: g };
}
function Re({ row: e, column: i }, b) {
  if (!e) return;
  const n = W(b);
  let a = true;
  return e.verify && Object.keys(e.verify) && Object.keys(e.verify).length > 0 && (e.verify[i.property] === false && (a = F(i.property, n[i.property], e)), a && (e.verify[i.property] = true)), a ? "" : "mask-td";
}
function F(e, i, b = {}) {
  const n = we(b, e);
  let a = true;
  if (q(i)) return a;
  let g = 0;
  for (g = 0; g < i.length; g++) {
    const p = i[g], k = p.pattern;
    if (k && !k.test(n || "")) {
      a = false;
      break;
    }
    const w = p.validator;
    if (typeof w == "function" && w(n, b) === false) {
      a = false;
      break;
    }
    if (p.required === true && q(n)) {
      a = false;
      break;
    }
    const x = p.type;
    if (x && typeof n !== x) {
      a = false;
      break;
    }
    const c = p.max, L = p.min;
    if (typeof n == "string" && (L && L !== 0 && n.length < L || c && c !== 0 && c < n.length)) {
      a = false;
      break;
    }
  }
  return a || console.error(`${e}：${i[g].message}`), a;
}
function Ie(e, i = /* @__PURE__ */ new Map()) {
  const b = re(e);
  e.length = 0, b.forEach((a, g) => {
    i.forEach((w, r) => {
      a[r] === w && delete a[r];
    }), delete a.uid, T(a).some((w) => j(w)) && e.push(a);
  });
  const n = /* @__PURE__ */ new Map();
  return e.forEach((a) => {
    delete a.verify, i.forEach((g, p) => {
      q(a[p]) ? a[p] = n.get(p) : n.set(p, a[p]);
    });
  }), e;
}
function W(e) {
  let i;
  switch (e.constructor.name) {
    case "EL":
    case "RefImpl":
    case "ComputedRefImpl":
      i = e.value;
      break;
    default:
      i = e;
      break;
  }
  return i;
}
const Me = { class: "add-row-box" }, Ee = { __name: "assistance-detail-form", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, detailList: { type: Array, default: () => [] }, nextProcessList: { type: Array, default: () => [] }, classIdGroupsObj: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(e, { emit: i }) {
  const b = _(false), n = _([]), a = _(false), g = _([]), p = _(false), k = _([]);
  _([]);
  const w = i, r = e, x = _(), c = _({ id: void 0, list: [], productionLineId: void 0 }), L = _(), { visible: h, handleClose: C } = _e({ emit: w, props: r, field: "visible" });
  de(() => h.value, (s) => {
    var l;
    s && (c.value.list = [], a.value = false, n.value = [], console.log(r.detailList, "props.detailList"), r.detailList.length && ((l = r.detailList) == null || l.forEach((y) => {
      var o;
      y.numbersMap = (o = y == null ? void 0 : y.numbers) == null ? void 0 : o.map((f) => f.number);
      const v = Object.assign(y, JSON.parse(JSON.stringify(r.detailData)));
      c.value.list.push(v);
    })));
  }, { immediate: true, deep: true });
  const { maxHeight: J } = ke({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body", ".upload-table"], navbar: false, extraHeight: 120 }, L.value), U = (s, l) => !!s, z = { quantity: [{ validator: (s, l) => !!s, required: true, message: "输入协同数量", trigger: "blur" }], productionLineId: [{ validator: U, required: true, message: "选择生产组", trigger: "change" }] }, Q = { numbersMap: [{ required: true, message: "选择一物一码", trigger: "change" }], productionLineId: [{ validator: U, required: true, message: "选择生产组", trigger: "change" }] }, G = ue(() => r.detailData.boolOnecode ? Q : z), { tableValidate: H, wrongCellMask: K } = Le({ rules: G });
  function X(s) {
    k.value = s;
  }
  function Y(s, l, y, v) {
    if (!l.productionLineId) {
      const o = v.panel.menuList[0];
      A(o, o.nodes[0]);
    }
  }
  function A(s, l) {
    l.isLeaf || (s.panel.expandNode(l, true), l.children[0].isLeaf || A(s, l.children[0]));
  }
  function Z(s, l, y, v) {
    const o = v.panel.menuList[0], f = o.panel.expandingNode;
    f.children[0].isLeaf || A(o, f.children[0]);
  }
  async function ee() {
    var y;
    const s = { boolUpdateGroup: true, boolCanDelete: true }, l = Object.assign(JSON.parse(JSON.stringify(r.detailData)), s);
    c.value.list.push(l), (y = c.value.list) == null || y.forEach((v, o) => {
      var f;
      (f = v == null ? void 0 : v.mesBuildingAssistDetailDTOS) == null || f.forEach((D, $) => {
        D.disabledNumberArr = [].concat(D.numbersMap);
      });
    }), console.log(c.value.list, "addRow");
  }
  function te(s) {
    c.value.list.splice(s, 1);
  }
  function ae(s, l) {
    console.log(s, c.value.list, "change");
  }
  function le() {
    b.value = false, a.value = true, P();
  }
  async function P() {
    var y, v;
    p.value = true;
    const { validResult: s, dealList: l } = H(c.value.list);
    if (console.log(c.value, x.value, "form.value"), s) c.value.list = l;
    else return s;
    if ((y = r.nextProcessList) != null && y.length && !a.value) {
      b.value = true, n.value = r.nextProcessList.map((o) => o.id);
      return;
    }
    try {
      const o = (v = c.value.list) == null ? void 0 : v.map((f) => ({ artifactTaskId: f.artifactTaskId, id: f.id, quantity: f.boolOnecode ? 0 : f.quantity, productionLineId: f.productionLineId, numbers: f.boolOnecode ? f.numbersMap : [], nextProcessIds: n.value || [] }));
      await ye({ assistList: o, nextProcessIds: n.value || [], id: r.detailData.id }), me({ title: "工序协同保存成功", type: "success", duration: 2500 }), C(), w("success");
    } catch (o) {
      console.log("保存工序协同报错", o);
    } finally {
      p.value = false;
    }
  }
  return (s, l) => {
    const y = be, v = M("common-button"), o = ge, f = M("common-select"), D = M("common-input-number"), $ = he, oe = M("common-table"), ne = ve, se = M("common-drawer");
    return E(), ce(fe, null, [u(se, { "append-to-body": "", "close-on-click-modal": false, "before-close": N(C), visible: N(h), "onUpdate:visible": l[1] || (l[1] = (t) => pe(h) ? h.value = t : null), title: "工序协同", "wrapper-closable": false, ref_key: "drawerRef", ref: L, size: "90%" }, { titleAfter: m(() => [u(y, { effect: "plain" }, { default: m(() => {
      var t, d;
      return [B(" 可协同数：" + R(((d = (t = e.detailData) == null ? void 0 : t.totalCanAssistMete) == null ? void 0 : d.quantity) || 0), 1)];
    }), _: 1 })]), titleRight: m(() => [u(v, { size: "default", type: "primary", onClick: P }, { default: m(() => l[4] || (l[4] = [B("保存")])), _: 1, __: [4] })]), content: m(() => [u(ne, { ref_key: "formRef", ref: x, model: c.value, size: "default", "label-width": "140px" }, { default: m(() => [u(oe, { ref: "detailRef", border: "", data: c.value.list, "max-height": N(J), style: { width: "100%", "margin-top": "10px" }, class: "upload-table", "return-source-data": "", showEmptySymbol: false, "cell-class-name": N(K), onSelectionChange: X }, { default: m(() => [u(o, { label: "序号", type: "index", align: "center", width: "60" }), u(o, { prop: "areaName", "show-overflow-tooltip": true, label: "区域", "min-width": "100px", align: "center" }), u(o, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100px", align: "center" }), u(o, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "100px", align: "center" }), u(o, { prop: "length", "show-overflow-tooltip": true, label: "长度(mm)", width: "100px", align: "center" }), u(o, { align: "center", prop: "totalTaskMete.netWeight", "show-overflow-tooltip": true, label: "任务总净重（kg）" }, { default: m(({ row: t }) => {
      var d;
      return [I("span", null, R(((d = t.totalTaskMete) == null ? void 0 : d.netWeight) || 0), 1)];
    }), _: 1 }), u(o, { align: "center", prop: "totalTaskMete.grossWeight", "show-overflow-tooltip": true, label: "任务总毛重（kg）" }, { default: m(({ row: t }) => {
      var d;
      return [I("span", null, R(((d = t.totalTaskMete) == null ? void 0 : d.grossWeight) || 0), 1)];
    }), _: 1 }), u(o, { align: "center", prop: "totalCompleteMete.netWeight", "show-overflow-tooltip": true, label: "完成总净重（kg）" }, { default: m(({ row: t }) => {
      var d;
      return [I("span", null, R(((d = t.totalCompleteMete) == null ? void 0 : d.netWeight) || 0), 1)];
    }), _: 1 }), u(o, { align: "center", prop: "totalCompleteMete.grossWeight", "show-overflow-tooltip": true, label: "完成总毛重（kg）" }, { default: m(({ row: t }) => {
      var d;
      return [I("span", null, R(((d = t.totalCompleteMete) == null ? void 0 : d.grossWeight) || 0), 1)];
    }), _: 1 }), u(o, { align: "center", prop: "produceQuantity", "show-overflow-tooltip": true, label: "已完成数" }, { default: m(({ row: t }) => [I("span", null, R(t.produceQuantity || 0), 1)]), _: 1 }), e.detailData.boolOnecode ? (E(), O(o, { key: 0, prop: "numbersMap", "show-overflow-tooltip": true, label: "一物一码", "min-width": "130px", "header-align": "center" }, { default: m(({ row: t }) => [u(f, { modelValue: t.numbersMap, "onUpdate:modelValue": (d) => t.numbersMap = d, type: "other", options: e.detailData.numberArr, dataStructure: { key: "id", label: "label", value: "id" }, "collapse-tags": "", multiple: "", clearable: "", disabledVal: t.disabledNumberArr, placeholder: "选择一物一码", style: { width: "100%" }, onChange: ae }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabledVal"])]), _: 1 })) : S("", true), e.detailData.boolOnecode ? S("", true) : (E(), O(o, { key: 1, align: "center", prop: "quantity", "show-overflow-tooltip": true, label: "协同数量", width: "160px" }, { default: m(({ row: t }) => [u(D, { modelValue: t.quantity, "onUpdate:modelValue": (d) => t.quantity = d, step: 1, controls: false, placeholder: "协同数量", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })), u(o, { "show-overflow-tooltip": true, prop: "productionLineId", label: "协同生产线", "min-width": "150px", align: "center" }, { default: m(({ row: t }) => {
      var d;
      return [u($, { modelValue: t.productionLineId, "onUpdate:modelValue": (V) => t.productionLineId = V, ref: (V) => g.value[s.$index] = V, options: (d = e.classIdGroupsObj[t.configId]) == null ? void 0 : d.list, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": "", disabled: !t.boolUpdateGroup, filterable: "", clearable: "", placeholder: "选择协同生产线", style: { width: "100%" }, onExpandChange: (V) => Z(V, t, s.$index, g.value[s.$index]), onFocus: (V) => Y(V, t, s.$index, g.value[s.$index]) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled", "onExpandChange", "onFocus"])];
    }), _: 1 }), c.value.id ? S("", true) : (E(), O(o, { key: 2, label: "操作", align: "center", width: "100" }, { default: m((t) => [u(v, { size: "default", disabled: !t.row.boolCanDelete, icon: "el-icon-delete", type: "danger", onClick: (d) => te(t.$index) }, null, 8, ["disabled", "onClick"])]), _: 1 }))]), _: 1 }, 8, ["data", "max-height", "cell-class-name"]), I("div", Me, [c.value.id ? S("", true) : (E(), O(v, { key: 0, size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-top": "15px" }, onClick: l[0] || (l[0] = (t) => ee()) }, { default: m(() => l[5] || (l[5] = [B("添加")])), _: 1, __: [5] }))])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible"]), u(N(Ce), { visible: b.value, "onUpdate:visible": l[2] || (l[2] = (t) => b.value = t), modelValue: n.value, "onUpdate:modelValue": l[3] || (l[3] = (t) => n.value = t), "next-process-list": e.nextProcessList, onNextProcessAssistSelectConfirm: le }, null, 8, ["visible", "modelValue", "next-process-list"])], 64);
  };
} }, qe = xe(Ee, [["__scopeId", "data-v-0eccb732"]]);
export {
  qe as default
};
