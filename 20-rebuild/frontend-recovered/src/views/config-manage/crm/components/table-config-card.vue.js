import { ref as V } from "vue";
import { ElMessage as S } from "element-plus";
import { watchEffect as W } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as f } from "vue";
import { createBlock as y } from "vue";
import { withCtx as b } from "vue";
import { createElementVNode as j } from "vue";
import { toDisplayString as q } from "vue";
import { unref as u } from "vue";
import { createTextVNode as M } from "vue";
import { createCommentVNode as d } from "vue";
import { renderSlot as I } from "vue";
import { createVNode as $ } from "vue";
import { createElementBlock as z } from "vue";
import { Fragment as J } from "vue";
import { Top as Q } from "@element-plus/icons-vue";
import { Bottom as X } from "@element-plus/icons-vue";
import { normalizeStyle as Z } from "vue";
import { ElTableColumn as ee } from "element-plus";
import { ElCard as te } from "element-plus";
import { l as P, dv as p, o as ae, aw as ne, G as h, dw as A, V as Y, aI as oe } from "../../../../shared/runtime.js";
import { g as re, s as se } from "../../../../modules/project-config-3fa4f850.js";
import { g as le, s as ie } from "../../../../modules/tender-apply-c04ffc5b.js";
function ce(a) {
  return P({ module: "crm", url: "number/prefix/config", method: "get", cancelKey: false, params: a });
}
function ue(a) {
  return P({ module: "crm", url: "number/prefix/config", method: "post", data: a });
}
function ve(a) {
  return P({ module: "crm", url: "page/management/config/get/style/layout", method: "get", cancelKey: false, params: a });
}
function me(a) {
  return P({ module: "crm", url: "page/management/config", method: "get", cancelKey: false, params: a });
}
function fe(a, T) {
  return P({ module: "crm", url: "page/management/config", method: "post", params: a, data: T });
}
function de() {
  const a = V([]);
  async function T({ configEnum: e, pageType: o, countryType: l, otherEnum: t }) {
    try {
      let g = [];
      switch (o) {
        case p.PROJECT_INFORMATION.V:
          g = await n(e);
          break;
        case p.TENDER_APPLY.V:
          g = await v(e, t);
          break;
        case p.NUMBER_CONFIG.V:
          g = await C();
          break;
        case p.PAGE_MANAGE.V:
          g = await R(e, o, l);
          break;
      }
      a.value = g;
    } catch (g) {
      console.log(g, "获取列表信息");
    }
  }
  async function n(e) {
    try {
      return (await re({ crmProjectInformationConfigEnum: e }))[0].crmProjectInformationConfigDTOS;
    } catch (o) {
      console.log(o, "项目信息查询");
    }
  }
  async function v(e, o) {
    try {
      return (await le({ crmTenderRequestConfigEnum: e, crmSpecialBubmissionStatusEnum: o }))[0].crmTenderRequestConfigDTOS;
    } catch (l) {
      console.log(l, "投标申请查询");
    }
  }
  async function C() {
    try {
      return await ce();
    } catch {
      console.log("编号配置列表");
    }
  }
  async function R(e, o, l) {
    try {
      console.log(e, "configEnum111");
      const t = await me({ crmPageManagementConfigEnum: e, crmCountryTypeEnum: l });
      return console.log(t), t;
    } catch (t) {
      console.log(t, "配置管理详情");
    }
  }
  async function D({ pageType: e, configEnum: o, otherEnum: l, list: t, countryType: g }) {
    try {
      switch (e) {
        case p.PROJECT_INFORMATION.V:
          await L(o, t);
          break;
        case p.TENDER_APPLY.V:
          await m(o, l, t);
          break;
        case p.NUMBER_CONFIG.V:
          t = await N(t);
          break;
        case p.PAGE_MANAGE.V:
          t = await k(o, t, g);
          break;
      }
    } catch (_) {
      throw console.log(_, "提交配置"), _;
    }
  }
  async function L(e, o) {
    try {
      await se({ crmProjectInformationConfigEnum: e }, o) && S.success("保存成功");
    } catch (l) {
      console.log(l);
    }
  }
  async function m(e, o, l) {
    try {
      await ie({ crmTenderRequestConfigEnum: e, crmSpecialBubmissionStatusEnum: o }, l) && S.success("保存成功");
    } catch (t) {
      console.log(t);
    }
  }
  async function N(e) {
    try {
      const o = [];
      e.forEach((t) => {
        t.prefixNaming && o.push(t);
      }), await ue(o) && S.success("保存成功");
    } catch (o) {
      console.log(o);
    }
  }
  async function k(e, o, l) {
    try {
      await fe({ crmPageManagementConfigEnum: e }, o, { crmCountryTypeEnum: l }) && S.success("保存成功");
    } catch (t) {
      throw console.log(t), t;
    }
  }
  return { tableData: a, fetchTableList: T, submitData: D };
}
const ge = { class: "clearfix" }, ye = { class: "card-title" }, pe = { key: 0 }, be = { __name: "table-config-card", props: { title: { type: String, default: "" }, configEnum: { type: Number, default: void 0 }, pageType: { type: String, default: void 0 }, boolControls: { type: Boolean, default: true }, boolAdd: { type: Boolean, default: true }, allowEmpty: Boolean, boolSerialNumber: { type: Boolean, default: true }, addHeight: { type: Number, default: 0 }, tableRules: { type: Object, default: () => {
} }, isCanSort: { type: Boolean, default: false }, isOperation: { type: Boolean, default: true }, permission: { type: Object, default: () => {
} }, countryType: { type: Number }, otherEnum: { type: Number, default: void 0 } }, emits: ["edit", "cancelEdit", "submit-success"], setup(a, { emit: T }) {
  const n = a, v = T, { maxHeight: C } = ae(), { tableValidate: R, cleanUpData: D, wrongCellMask: L } = ne({ rules: n.tableRules }), m = V(false), N = V([]), k = V(false), { tableData: e, fetchTableList: o, submitData: l } = de();
  W(() => {
    t(n.configEnum, n.countryType);
  });
  async function t(r, s) {
    h(n.permission.get) && (m.value = false, await o({ configEnum: r, pageType: n.pageType, countryType: s, otherEnum: n.otherEnum }));
  }
  function g() {
    m.value = true, N.value = Y(e.value), C.value = C.value + 1, v("edit", m.value);
  }
  function _(r) {
    const s = Y({});
    s.uid = oe(), r.push(s);
  }
  function G(r) {
    e.value.splice(r, 1);
  }
  function F() {
    e.value = N.value, C.value = C.value - 1, m.value = false, v("cancelEdit", m.value);
  }
  function K(r) {
    if (r === 0) return;
    const s = e.value[r];
    e.value.splice(r, 1), e.value.splice(r - 1, 0, s);
  }
  function H(r) {
    if (r === e.value.length - 1) return;
    const s = e.value[r];
    e.value.splice(r, 1), e.value.splice(r + 1, 0, s);
  }
  async function U() {
    const removedAllRows = n.allowEmpty && N.value.length > 0 && e.value.length === 0;
    const { validResult: r, dealList: s } = removedAllRows
      ? { validResult: true, dealList: [] }
      : R(e.value);
    if (!r) return;
    const i = D(s), w = n.isOperation ? n.boolControls ? i == null ? void 0 : i.map((c, O) => ({ id: c.id, name: c.name, sort: c.sort })) : i == null ? void 0 : i.map((c, O) => ({ id: c.id, name: c.name, isWrite: c.isWrite, isShow: c.isShow, sort: O + 1 })) : i == null ? void 0 : i.map((c) => ({ id: c.id, prefixNaming: c.prefixNaming, numberPrefixConfigEnum: c.numberPrefixConfigEnum, sort: c.sort }));
    try {
      await l({ configEnum: n.configEnum, list: w, pageType: n.pageType, countryType: n.countryType, otherEnum: n.pageType === p.TENDER_APPLY.V && n.configEnum === A.WORK_CONTENT_TYPE.V ? n.otherEnum : void 0 }), m.value = false, v("submit-success", m.value), t(n.configEnum, n.countryType);
    } catch (c) {
      console.log(c, "提交保存");
    } finally {
      k.value = false;
    }
  }
  return (r, s) => {
    const i = x("common-button"), w = ee, c = x("common-table"), O = te;
    return f(), y(O, { style: Z({ width: a.pageType === u(p).TENDER_APPLY.V && a.configEnum === u(A).WORK_CONTENT_TYPE.V ? "800px" : "", height: 400 + n.addHeight + "px" }) }, { header: b(() => [j("div", ge, [j("span", ye, q(n.title), 1), !m.value && u(h)(a.permission.edit) ? (f(), y(i, { key: 0, style: { float: "right" }, type: "primary", size: "small", onClick: g }, { default: b(() => s[1] || (s[1] = [M(" 编辑 ")])), _: 1, __: [1] })) : d("", true), m.value && u(h)(a.permission.save) ? (f(), y(i, { key: 1, style: { float: "right", "margin-left": "8px" }, type: "success", size: "small", loading: k.value, onClick: U }, { default: b(() => s[2] || (s[2] = [M(" 保存 ")])), _: 1, __: [2] }, 8, ["loading"])) : d("", true), m.value && n.boolAdd && u(h)(a.permission.add) ? (f(), y(i, { key: 2, icon: "el-icon-plus", style: { float: "right", "margin-left": "8px" }, type: "warning", size: "small", onClick: s[0] || (s[0] = (E) => _(u(e))) })) : d("", true), m.value ? (f(), y(i, { key: 3, style: { float: "right" }, type: "info", size: "small", onClick: F }, { default: b(() => s[3] || (s[3] = [M("取消编辑")])), _: 1, __: [3] })) : d("", true)])]), default: b(() => [I(r.$slots, "filterBtn"), $(c, { data: u(e), showEmptySymbol: false, "return-source-data": "", "max-height": a.pageType === u(p).TENDER_APPLY.V && a.configEnum === u(A).WORK_CONTENT_TYPE.V ? 240 : 290 + n.addHeight, "cell-class-name": u(L) }, { default: b(() => [n.boolSerialNumber ? (f(), y(w, { key: 0, type: "index", align: "center", label: "序号", width: "60" })) : d("", true), I(r.$slots, "tableColumn"), a.isOperation ? (f(), z(J, { key: 1 }, [n.boolControls ? (f(), y(w, { key: 0, align: "center", label: "操作", width: "100" }, { default: b(({ $index: E }) => [m.value && u(h)(a.permission.del) ? (f(), y(i, { key: 0, icon: "el-icon-delete", type: "danger", size: "small", onClick: (B) => G(E) }, null, 8, ["onClick"])) : d("", true)]), _: 1 })) : d("", true), n.boolControls ? d("", true) : (f(), y(w, { key: 1, align: "center", label: "操作", width: "120" }, { default: b(({ $index: E }) => [m.value ? (f(), z("div", pe, [u(h)(a.permission.upSort) ? (f(), y(i, { key: 0, size: "small", icon: u(Q), disabled: E === 0, onClick: (B) => K(E), type: "success" }, null, 8, ["icon", "disabled", "onClick"])) : d("", true), u(h)(a.permission.downSort) ? (f(), y(i, { key: 1, size: "small", icon: u(X), disabled: E === u(e).length - 1, onClick: (B) => H(E), type: "warning" }, null, 8, ["icon", "disabled", "onClick"])) : d("", true)])) : d("", true)]), _: 1 }))], 64)) : d("", true)]), _: 3 }, 8, ["data", "max-height", "cell-class-name"])]), _: 3 }, 8, ["style"]);
  };
} }, we = Object.freeze(Object.defineProperty({ __proto__: null, default: be }, Symbol.toStringTag, { value: "Module" }));
export {
  be as _,
  ve as g,
  we as t
};
