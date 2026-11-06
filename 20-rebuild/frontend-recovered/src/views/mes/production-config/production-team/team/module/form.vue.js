import { ref as i } from "vue";
import { computed as P } from "vue";
import { watchEffect as J } from "vue";
import { watch as S } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as m } from "vue";
import { createBlock as h } from "vue";
import { withCtx as a } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { createTextVNode as b } from "vue";
import { createCommentVNode as X } from "vue";
import { createElementBlock as Z } from "vue";
import { Fragment as ee } from "vue";
import { renderList as te } from "vue";
import { ElCascader as oe } from "element-plus";
import { ElFormItem as le } from "element-plus";
import { ElRadio as re } from "element-plus";
import { ElRadioGroup as ae } from "element-plus";
import { ElOption as ne } from "element-plus";
import { ElSelect as se } from "element-plus";
import { ElForm as de } from "element-plus";
import { l as p, aY as x, ao as ue, V as z, a3 as ie, er as ce } from "../../../../../../shared/runtime.js";
import { _ as me } from "../../../../../../modules/process-select-b35dffc0.js";
import { u as q } from "../../../../../../modules/index-9d220fe1.js";
function pe(d) {
  return p({ module: "mes", url: "team/page", method: "get", params: d });
}
function fe(d) {
  return p({ module: "mes", url: "team", method: "post", data: d });
}
function he(d) {
  return p({ module: "mes", url: "team", method: "put", data: d });
}
function ge(d) {
  return p({ module: "mes", url: "team", method: "delete", data: { ids: d } });
}
function Ve(d) {
  return p({ module: "mes", url: "team/status", method: "put", params: d });
}
function ye(d) {
  return p({ module: "mes", url: "process/getPartListTree", method: "get", params: d });
}
const Le = { get: pe, add: fe, edit: he, del: ge }, be = { __name: "form", setup(d) {
  const _ = i(), U = i(), M = i(), F = i(), N = i(), v = i(), g = i(), I = i([]), O = { id: void 0, processId: void 0, leaderId: void 0, organizationType: x.IN_STAFF.V, productionLineId: void 0, memberIds: [], hasMen: true }, { crud: s, form: o, CRUD: T } = ue(O, _), E = P(() => s.status.edit >= 1), f = i([]);
  let y = [];
  const A = P(() => ({ value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false })), B = { productionLineId: [{ required: true, message: "请选择生产线", trigger: "change" }], processId: [{ required: true, message: "请选择工序", trigger: "change" }], organizationType: [{ required: true, message: "请选择班组属性", trigger: "change" }], leaderId: [{ required: true, message: "请选择组长", trigger: "change" }], hasMen: [{ required: true, message: "请选择是否组员", trigger: "change" }], memberIds: [{ required: true, message: "请选择组员", trigger: "change" }] };
  J(() => {
    var l;
    v.value && E && (N.value = (l = v.value.getOption(o.productionLineId)) == null ? void 0 : l.productType);
  });
  async function V() {
    try {
      const { content: l } = await ce({ workShopType: s.query.mesProductEnum });
      l.forEach((e) => {
        e.children = e.workshopList, e.workshopList.forEach((u) => {
          u.children = u.productionLineList;
        });
      }), f.value = l[0].children.filter((e) => e.children.length > 0), y = l[0].children.filter((e) => e.children.length > 0);
    } catch {
      console.log("请求工厂-车间-生产线的层级接口失败");
    }
  }
  V();
  async function j() {
    const l = await ye({});
    I.value = l.map((e) => (k(e), e));
  }
  j(), S(() => s.query.mesProductEnum, () => {
    V();
  }), S(() => s.query.taskTypeEnum, () => {
    s.query.taskTypeEnum ? f.value = y.map((l) => {
      const e = z(l);
      return e.children = e.children.filter((u) => u.productType === s.query.taskTypeEnum), e;
    }) : f.value = z(y);
  });
  function L(l) {
    f.value.forEach((e) => {
      e.children.forEach((u) => {
        u.id === l && (g.value = u.productType);
      });
    });
  }
  function H(l) {
    o.leader = l;
  }
  function D(l) {
    o.members = l;
  }
  function G() {
    o.memberIds = [], o.members = [], o.memberNames = "";
  }
  function k(l) {
    if (l.children && l.children.length === 0 && (l.children = l.processNames), l.children && l.children.length > 0) for (const e of l.children) k(e);
    return l;
  }
  return T.HOOK.beforeSubmit = async () => {
    o.mesProductEnum = s.query.mesProductEnum;
  }, T.HOOK.beforeToEdit = () => {
    L(o.productionLineId), console.log(" currentProductType.value:", g.value, o.productionLineId);
  }, (l, e) => {
    const u = R("common-button"), C = oe, c = le, w = re, K = ae, W = ne, Q = se, Y = de, $ = R("common-dialog");
    return m(), h($, { "append-to-body": "", "close-on-click-modal": false, "before-close": t(s).cancelCU, visible: t(s).status.cu > 0, title: t(s).status.title, width: "550px" }, { titleRight: a(() => [n(u, { loading: t(s).status.cu === 2, type: "primary", size: "default", onClick: t(s).submitCU }, { default: a(() => e[7] || (e[7] = [b("确认")])), _: 1, __: [7] }, 8, ["loading", "onClick"])]), default: a(() => [n(Y, { ref_key: "formRef", ref: _, model: t(o), rules: B, size: "default", "label-width": "150px" }, { default: a(() => [n(c, { label: "生产线", prop: "productionLineId" }, { default: a(() => [n(C, { modelValue: t(o).productionLineId, "onUpdate:modelValue": e[0] || (e[0] = (r) => t(o).productionLineId = r), options: f.value, "check-strictly": "", "show-all-levels": false, props: A.value, separator: " > ", clearable: "", size: "default", class: "filter-item", style: { width: "270px" }, placeholder: "请选择生产线", onChange: L }, null, 8, ["modelValue", "options", "props"])]), _: 1 }), n(c, { label: "工序", prop: "processId" }, { default: a(() => [g.value !== t(ie).MACHINE_PART.V ? (m(), h(t(me), { key: 0, ref_key: "processSelectRef", ref: U, modelValue: t(o).processId, "onUpdate:modelValue": e[1] || (e[1] = (r) => t(o).processId = r), disabled: !t(o).productionLineId || E.value && t(o).boolBindProcess, productionLineTypeEnum: t(s).query.productionLineTypeEnum, size: "default", multiple: false, style: { width: "270px" }, productType: g.value }, null, 8, ["modelValue", "disabled", "productionLineTypeEnum", "productType"])) : (m(), h(C, { key: 1, ref: "cascader", modelValue: t(o).processId, "onUpdate:modelValue": e[2] || (e[2] = (r) => t(o).processId = r), options: I.value, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": false, separator: " > ", style: { width: "270px" }, filterable: "", placeholder: "请选择工序" }, null, 8, ["modelValue", "options"]))]), _: 1 }), n(c, { label: "组长", prop: "leaderId" }, { default: a(() => [n(t(q), { ref_key: "leaderSelectRef", ref: M, modelValue: t(o).leaderId, "onUpdate:modelValue": e[3] || (e[3] = (r) => t(o).leaderId = r), size: "default", "disabled-value": [...t(o).memberIds], placeholder: "请选择班组组长", style: { width: "270px" }, onChange: H }, null, 8, ["modelValue", "disabled-value"])]), _: 1 }), n(c, { label: "是否需要组员", prop: "hasMen" }, { default: a(() => [n(K, { modelValue: t(o).hasMen, "onUpdate:modelValue": e[4] || (e[4] = (r) => t(o).hasMen = r), onChange: G }, { default: a(() => [n(w, { value: true }, { default: a(() => e[8] || (e[8] = [b("是")])), _: 1, __: [8] }), n(w, { value: false }, { default: a(() => e[9] || (e[9] = [b("否")])), _: 1, __: [9] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), t(o).hasMen ? (m(), h(c, { key: 0, label: "组员", prop: "memberIds" }, { default: a(() => [n(t(q), { ref_key: "memberSelectRef", ref: F, modelValue: t(o).memberIds, "onUpdate:modelValue": e[5] || (e[5] = (r) => t(o).memberIds = r), size: "default", "disabled-value": [t(o).leaderId], placeholder: "请选择班组成员", multiple: true, style: { width: "270px" }, onChange: D }, null, 8, ["modelValue", "disabled-value"])]), _: 1 })) : X("", true), n(c, { label: "性质", prop: "organizationType" }, { default: a(() => [n(Q, { modelValue: t(o).organizationType, "onUpdate:modelValue": e[6] || (e[6] = (r) => t(o).organizationType = r), placeholder: "请选择班组属性", size: "default", style: { width: "270px" } }, { default: a(() => [(m(true), Z(ee, null, te(t(x).ENUM, (r) => (m(), h(W, { key: r.V, label: r.L, value: r.V }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, ke = Object.freeze(Object.defineProperty({ __proto__: null, default: be }, Symbol.toStringTag, { value: "Module" }));
export {
  be as _,
  Le as c,
  Ve as e,
  ke as f
};
