import { ref as f } from "vue";
import { inject as R } from "vue";
import { reactive as ne } from "vue";
import { computed as ie } from "vue";
import { watch as E } from "vue";
import { resolveComponent as I } from "vue";
import { resolveDirective as se } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as L } from "vue";
import { createVNode as t } from "vue";
import { withCtx as u } from "vue";
import { withDirectives as re } from "vue";
import { createBlock as w } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as h } from "vue";
import { unref as o } from "vue";
import { createElementVNode as S } from "vue";
import { createCommentVNode as v } from "vue";
import { Fragment as T } from "vue";
import { withModifiers as ue } from "vue";
import { isRef as de } from "vue";
import { ElMessage as Q } from "element-plus";
import { ElFormItem as pe } from "element-plus";
import { ElForm as ce } from "element-plus";
import { ElTableColumn as me } from "element-plus";
import { ElInputNumber as fe } from "element-plus";
import { ElInput as he } from "element-plus";
import { e as ge, p as be, b as ye } from "../../../../../modules/manual-pack-01ad3a57.js";
import { u as _e, o as we, bw as s, aV as ke, br as ve, bs as U, D as A, ba as xe } from "../../../../../shared/runtime.js";
import { o as Ve } from "../../../../../modules/one-code-number-list-d40dfaf0.js";
import Ce from "../chose-add-method-dialog/index.vue.js";
const Ie = { class: "head-container" }, Le = { key: 1 }, Qe = { __name: "index", props: { visible: { type: Boolean, default: false }, bagId: { type: [Number, String], default: void 0 }, editData: { type: Object, default: () => {
} } }, emits: ["update:visible", "handleSuccess"], setup(P, { emit: j }) {
  const H = f(), B = f(), W = f([]), g = R("packData"), z = R("permission"), F = R("projectId"), D = j, b = P, { visible: x, handleClose: K } = _e({ emit: D, props: b, field: "visible" }), { maxHeight: X } = we({ mainBox: ".drawer-detail", extraBox: [".el-drawer__header", ".head-container", ".remark-detail"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300, extraHeight: 80 }, x), r = f(s.BOX.V), V = f(false), N = f(false), C = f(), y = f(), p = ne({}), $ = ie(() => {
    var l;
    const a = [];
    for (const n in s.ENUM) (l = p["source" + n]) != null && l.length || a.push(s.KV[n]);
    return a;
  });
  E(C, (a) => {
    var l;
    for (const n in s.ENUM) (l = p["source" + n]) != null && l.length && (p[n] = p["source" + n].filter((d) => a === d.workshopInf.id || !a));
  }), E(g, () => {
    var l;
    let a;
    for (const n in s.ENUM) g[n] === null && (g[n] = {}), p[n] = Object.values(g[n]), p["source" + n] = Object.values(g[n]), (l = p[n]) != null && l.length && !a && (a = s.KV[n]);
    r.value = a || r.value;
  }, { immediate: true, deep: true }), E(() => b.bagId, (a) => {
    a && (y.value = b.editData.remark);
  }, { immediate: true });
  function q() {
    if (b.bagId) {
      O({ bagId: b.bagId });
      return;
    }
    N.value = true;
  }
  function G() {
    K(), y.value = "", r.value = s.BOX.V, C.value = void 0;
  }
  async function O({ bagId: a, isNew: l, selectBagId: n }) {
    try {
      V.value = true;
      const d = { remark: y.value, packageLinks: [], productType: r.value, projectId: F.value }, M = p[s.VK[r.value]];
      d.packageLinks = M.map((_) => ({ id: _.id, numberList: _.numberList, quantity: _.productQuantity })), a ? (d.id = a, await ge(d) && Q({ type: "success", message: "更新打包清单成功" })) : l ? await be(d) && Q({ type: "success", message: "打包成功" }) : (d.id = n, await ye(d) && Q({ type: "success", message: "追加打包成功" })), B.value.handleSuccess(), G(), D("handleSuccess");
    } catch (d) {
      console.log("手动打包", d);
    } finally {
      V.value = false;
    }
  }
  function Y(a) {
    a.productQuantity = a.numberList.length;
  }
  function J(a) {
    delete g[s.VK[r.value]][a];
  }
  function Z(a) {
    return xe(a, { props: ["inQuantity", "productQuantity"] });
  }
  return (a, l) => {
    const n = I("common-button"), d = I("component-radio-button"), M = pe, _ = ce, i = me, ee = fe, te = I("common-table"), ae = he, le = I("common-drawer"), oe = se("permission");
    return c(), L(T, null, [t(le, { ref_key: "drawerRef", ref: H, title: "打包列表", modelValue: o(x), "onUpdate:modelValue": l[3] || (l[3] = (e) => de(x) ? x.value = e : null), direction: "rtl", "before-close": o(K), size: "75%", "custom-class": "drawer-detail" }, { titleRight: u(() => [re((c(), w(n, { type: "primary", loading: V.value, size: "default", onClick: q }, { default: u(() => {
      var e;
      return [k(h(o(s).VL[r.value]) + "打包(" + h((e = p["source" + o(s).VK[r.value]]) == null ? void 0 : e.length) + ") ", 1)];
    }), _: 1 }, 8, ["loading"])), [[oe, o(z).pack]])]), content: u(() => [S("div", Ie, [t(d, { modelValue: r.value, "onUpdate:modelValue": l[0] || (l[0] = (e) => r.value = e), size: "default", class: "filter-item", options: o(s).ENUM, type: "enum", disabledVal: $.value }, { suffix: u(({ item: e }) => {
      var m;
      return [k(" (" + h((m = p["source" + e.K]) == null ? void 0 : m.length) + ")", 1)];
    }), _: 1 }, 8, ["modelValue", "options", "disabledVal"]), r.value !== o(s).AUXILIARY_MATERIAL.V ? (c(), w(o(ke), { key: 0, modelValue: C.value, "onUpdate:modelValue": l[1] || (l[1] = (e) => C.value = e), placeholder: "请选择车间", clearable: "", style: { width: "200px" }, class: "filter-item" }, null, 8, ["modelValue"])) : v("", true)]), t(te, { data: p[o(s).VK[r.value]], "return-source-data": "", "show-empty-symbol": false, "show-summary": "", "summary-method": Z, "empty-text": "暂无数据", "max-height": o(X), style: { width: "100%" }, class: "manual-pack-list", "expand-row-keys": W.value, "default-expand-all": "", "row-key": "rowKey" }, { default: u(() => [t(i, { type: "expand" }, { default: u(({ row: e }) => [e.boolOneCode ? (c(), w(_, { key: 0, style: { "padding-top": "20px", "padding-left": "20px" } }, { default: u(() => [t(M, { label: "一物一码编号：" }, { default: u(() => [t(o(Ve), { modelValue: e.numberList, "onUpdate:modelValue": (m) => e.numberList = m, list: e.originNumberList, "tag-width": 100, onChange: (m) => Y(e) }, null, 8, ["modelValue", "onUpdate:modelValue", "list", "onChange"])]), _: 2 }, 1024)]), _: 2 }, 1024)) : v("", true)]), _: 1 }), t(i, { label: "序号", type: "index", align: "center", width: "60" }), r.value === o(s).BOX.V || r.value === o(s).MACHINE_PART.V ? (c(), L(T, { key: 0 }, [t(i, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称", width: "120px" }, { default: u((e) => [e.row.workshopInf ? (c(), w(ve, { key: 0, name: e.row.workshopInf.name }, null, 8, ["name"])) : v("", true), S("span", null, h(e.row.name), 1)]), _: 1 }), t(i, { prop: "monomer.name", label: "单体", align: "center", width: "100px" }), t(i, { prop: "area.name", label: "区域", align: "center", width: "100px" }), t(i, { prop: "serialNumber", label: "编号", align: "center", width: "120px" }), t(i, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "140px" }), t(i, { key: "length", prop: "length", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: u((e) => [k(h(o(U)(e.row.length, o(A).MES_ARTIFACT_L__MM)), 1)]), _: 1 }), t(i, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "80px" }), t(i, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": true, label: `单净重
(kg)`, align: "left", "min-width": "80px" }, { default: u((e) => [k(h(o(U)(e.row.netWeight, o(A).COM_WT__KG)), 1)]), _: 1 }), t(i, { key: "grossWeight", prop: "grossWeight", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: u((e) => [k(h(o(U)(e.row.grossWeight, o(A).COM_WT__KG)), 1)]), _: 1 })], 64)) : v("", true), r.value === o(s).AUXILIARY_MATERIAL.V ? (c(), L(T, { key: 1 }, [t(i, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "120" }), t(i, { key: "fullClassName", prop: "fullClassName", "show-overflow-tooltip": true, label: "辅材类别", "min-width": "250" }), t(i, { key: "unit", prop: "unit", label: "单位", "min-width": "80px" }), t(i, { key: "color", prop: "color", "show-overflow-tooltip": true, label: "颜色", "min-width": "120" }), t(i, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120" })], 64)) : v("", true), t(i, { key: "inQuantity", prop: "inQuantity", label: "入库量", align: "center", "min-width": "80px" }), t(i, { key: "unPackageQuantity", prop: "unPackageQuantity", label: "可打包量", align: "center", "min-width": "80px" }), t(i, { prop: "productQuantity", label: "打包数量", align: "center", width: "120px", fixed: "right" }, { default: u(({ row: e }) => [e.boolOneCode ? (c(), L("span", Le, h(e.productQuantity), 1)) : (c(), w(ee, { key: 0, modelValue: e.productQuantity, "onUpdate:modelValue": (m) => e.productQuantity = m, step: 1, min: 1, max: e.unPackageQuantity || e.inQuantity - e.packageQuantity, size: "default", style: { width: "100%" }, "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue", "max"]))]), _: 1 }), t(i, { label: "操作", width: "70", align: "center", fixed: "right" }, { default: u((e) => [t(n, { type: "danger", icon: "el-icon-delete", size: "default", onClick: ue((m) => J(e.row.id), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "expand-row-keys"]), t(ae, { class: "remark-detail", modelValue: y.value, "onUpdate:modelValue": l[2] || (l[2] = (e) => y.value = e), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 3, maxRows: 3 }, maxlength: "255", placeholder: "请填写备注", style: { width: "100%", "margin-top": "10px" } }, null, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]), t(o(Ce), { ref_key: "choseDialogRef", ref: B, visible: N.value, "onUpdate:visible": l[4] || (l[4] = (e) => N.value = e), packType: r.value, packLoading: V.value, onHandlePack: O }, null, 8, ["visible", "packType", "packLoading"])], 64);
  };
} };
export {
  Qe as default
};
