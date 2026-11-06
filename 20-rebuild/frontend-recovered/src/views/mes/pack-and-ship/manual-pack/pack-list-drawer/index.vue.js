import { ref as f } from "vue";
import { inject as M } from "vue";
import { reactive as re } from "vue";
import { computed as H } from "vue";
import { watch as L } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as ue } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as E } from "vue";
import { createVNode as o } from "vue";
import { withCtx as s } from "vue";
import { withDirectives as de } from "vue";
import { createBlock as _ } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as g } from "vue";
import { unref as n } from "vue";
import { createElementVNode as O } from "vue";
import { createCommentVNode as y } from "vue";
import { Fragment as N } from "vue";
import { withModifiers as pe } from "vue";
import { isRef as ce } from "vue";
import { ElMessage as Q } from "element-plus";
import { ElFormItem as me } from "element-plus";
import { ElForm as fe } from "element-plus";
import { ElTableColumn as ge } from "element-plus";
import { ElInputNumber as he } from "element-plus";
import { ElInput as _e } from "element-plus";
import { e as ye, p as be, d as ke } from "../../../../../modules/manual-pack-695cccc1.js";
import { u as we, o as ve, bi as i, aV as xe, br as Ve, bs as S, D as A, ba as Ue } from "../../../../../shared/runtime.js";
import { o as Ce } from "../../../../../modules/one-code-number-list-af2f89eb.js";
import Re from "../chose-add-method-dialog/index.vue.js";
import "../../../../../modules/index-828ab502.js";
const Te = { class: "head-container" }, Ee = { key: 1 }, Ae = { __name: "index", props: { visible: { type: Boolean, default: false }, bagId: { type: [Number, String], default: void 0 }, editData: { type: Object, default: () => {
} } }, emits: ["update:visible", "handleSuccess"], setup(W, { emit: z }) {
  const F = f(), D = f(), $ = f([]), c = M("packData"), q = M("permission"), G = M("projectId"), B = z, b = W, { visible: V, handleClose: j } = we({ emit: B, props: b, field: "visible" }), { maxHeight: X } = ve({ mainBox: ".drawer-detail", extraBox: [".el-drawer__header", ".head-container", ".remark-detail"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300, extraHeight: 80 }, V), r = f(i.STRUCTURE.V), U = f(false), I = f(false), C = f(), k = f(), d = re({}), Y = H(() => {
    const a = [];
    for (const t in i.ENUM) d["source" + t].length || a.push(i.KV[t]);
    return a;
  }), J = H(() => {
    let a = 0;
    for (const t in i.ENUM) d[t].length && (a += d[t].length);
    return a;
  });
  L(C, (a) => {
    for (const t in i.ENUM) d["source" + t].length && (d[t] = d["source" + t].filter((h) => {
      var u;
      return a === ((u = h.workshop) == null ? void 0 : u.id) || !a;
    }));
  }), L(c, () => {
    let a;
    for (const t in i.ENUM) c[t] === null && (c[t] = {}), c[t] === void 0 && (c[t] = {}), d[t] = Object.values(c[t]), d["source" + t] = Object.values(c[t]), d[t].length && !a && (a = i.KV[t]);
    r.value = a || r.value;
  }, { immediate: true, deep: true }), L(() => b.bagId, (a) => {
    a && (k.value = b.editData.remark);
  }, { immediate: true });
  function Z() {
    if (b.bagId) {
      K({ bagId: b.bagId });
      return;
    }
    I.value = true;
  }
  function ee() {
    j(), k.value = "", r.value = i.STRUCTURE.V, C.value = void 0;
  }
  async function K({ bagId: a, isNew: t, selectBagId: h }) {
    try {
      U.value = true;
      const u = { remark: k.value, packageLinks: [], productType: r.value, projectId: G.value };
      for (const R in i.ENUM) {
        const w = d[R];
        console.log(w, "_list");
        for (let l = 0; l < w.length; l++) {
          const v = w[l];
          u.packageLinks.push({ id: v.id, numberList: v.numberList, quantity: v.productQuantity, productType: i[R].V });
        }
      }
      a ? (u.id = a, await ye(u) && Q({ type: "success", message: "更新打包清单成功" })) : t ? await be(u) && Q({ type: "success", message: "打包成功" }) : (u.id = h, await ke(u) && Q({ type: "success", message: "追加打包成功" })), D.value.handleSuccess(), ee(), B("handleSuccess");
    } catch (u) {
      console.log("手动打包", u);
    } finally {
      U.value = false;
    }
  }
  function te(a) {
    a.productQuantity = a.numberList.length;
  }
  function ae(a) {
    delete c[i.VK[r.value]][a];
  }
  function oe(a) {
    return Ue(a, { props: ["inQuantity", "productQuantity"] });
  }
  return (a, t) => {
    const h = T("common-button"), u = T("component-radio-button"), R = me, w = fe, l = ge, v = he, le = T("common-table"), ne = _e, ie = T("common-drawer"), se = ue("permission");
    return p(), E(N, null, [o(ie, { ref_key: "drawerRef", ref: F, title: "打包列表", modelValue: n(V), "onUpdate:modelValue": t[3] || (t[3] = (e) => ce(V) ? V.value = e : null), direction: "rtl", "before-close": n(j), size: "75%", "custom-class": "drawer-detail" }, { titleRight: s(() => [de((p(), _(h, { type: "primary", loading: U.value, size: "default", onClick: Z }, { default: s(() => [x(" 打包 (" + g(J.value) + ") ", 1)]), _: 1 }, 8, ["loading"])), [[se, n(q).pack]])]), content: s(() => [O("div", Te, [o(u, { modelValue: r.value, "onUpdate:modelValue": t[0] || (t[0] = (e) => r.value = e), size: "default", class: "filter-item", options: n(i).ENUM, type: "enum", disabledVal: Y.value }, { suffix: s(({ item: e }) => [x(" (" + g(d["source" + e.K].length) + ")", 1)]), _: 1 }, 8, ["modelValue", "options", "disabledVal"]), r.value !== n(i).AUXILIARY_MATERIAL.V ? (p(), _(xe, { key: 0, modelValue: C.value, "onUpdate:modelValue": t[1] || (t[1] = (e) => C.value = e), placeholder: "请选择车间", clearable: "", style: { width: "200px" }, class: "filter-item" }, null, 8, ["modelValue"])) : y("", true)]), o(le, { data: d[n(i).VK[r.value]], "return-source-data": "", "show-empty-symbol": false, "show-summary": "", "summary-method": oe, "empty-text": "暂无数据", "max-height": n(X), style: { width: "100%" }, class: "manual-pack-list", "expand-row-keys": $.value, "default-expand-all": "", "row-key": "rowKey" }, { default: s(() => [o(l, { type: "expand" }, { default: s(({ row: e }) => [e.boolOneCode ? (p(), _(w, { key: 0, style: { "padding-top": "20px", "padding-left": "20px" } }, { default: s(() => [o(R, { label: "一物一码编号：" }, { default: s(() => [o(n(Ce), { modelValue: e.numberList, "onUpdate:modelValue": (m) => e.numberList = m, list: e.originNumberList, "tag-width": 100, onChange: (m) => te(e) }, null, 8, ["modelValue", "onUpdate:modelValue", "list", "onChange"])]), _: 2 }, 1024)]), _: 2 }, 1024)) : y("", true)]), _: 1 }), o(l, { label: "序号", type: "index", align: "center", width: "60" }), r.value & (n(i).STRUCTURE.V | n(i).MACHINE_PART.V) ? (p(), E(N, { key: 0 }, [r.value & n(i).STRUCTURE.V ? (p(), _(l, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称", width: "120px" }, { default: s((e) => {
      var m, P;
      return [(m = e.row.workshop) != null && m.name ? (p(), _(Ve, { key: 0, name: (P = e.row.workshop) == null ? void 0 : P.name }, null, 8, ["name"])) : y("", true), O("span", null, g(e.row.name), 1)];
    }), _: 1 })) : y("", true), o(l, { prop: "monomer.name", label: "单体", align: "center", width: "100px" }), o(l, { prop: "area.name", label: "区域", align: "center", width: "100px" }), o(l, { prop: "serialNumber", label: "编号", align: "center", width: "120px" }), o(l, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "140px" }), o(l, { key: "length", prop: "length", "show-overflow-tooltip": true, label: `长度
(mm)`, align: "left", "min-width": "85px" }, { default: s((e) => [x(g(n(S)(e.row.length, n(A).MES_ARTIFACT_L__MM)), 1)]), _: 1 }), o(l, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "80px" }), o(l, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": true, label: `单净重
(kg)`, align: "left", "min-width": "80px" }, { default: s((e) => [x(g(n(S)(e.row.netWeight, n(A).COM_WT__KG)), 1)]), _: 1 }), o(l, { key: "grossWeight", prop: "grossWeight", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: s((e) => [x(g(n(S)(e.row.grossWeight, n(A).COM_WT__KG)), 1)]), _: 1 })], 64)) : y("", true), r.value === n(i).AUXILIARY_MATERIAL.V ? (p(), E(N, { key: 1 }, [o(l, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称", "min-width": "120" }), o(l, { key: "measureUnit", prop: "measureUnit", label: "单位", "min-width": "80px" }), o(l, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120" })], 64)) : y("", true), o(l, { key: "inQuantity", prop: "inQuantity", label: "入库量", align: "center", "min-width": "80px" }), o(l, { key: "unPackageQuantity", prop: "unPackageQuantity", label: "可打包量", align: "center", "min-width": "80px" }), o(l, { prop: "productQuantity", label: "打包数量", align: "center", width: "120px", fixed: "right" }, { default: s(({ row: e }) => [e.boolOneCode ? (p(), E("span", Ee, g(e.productQuantity), 1)) : (p(), _(v, { key: 0, modelValue: e.productQuantity, "onUpdate:modelValue": (m) => e.productQuantity = m, step: 1, min: 1, max: e.unPackageQuantity || e.inQuantity - e.packageQuantity, size: "default", style: { width: "100%" }, "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue", "max"]))]), _: 1 }), o(l, { label: "操作", width: "70", align: "center", fixed: "right" }, { default: s((e) => [o(h, { type: "danger", icon: "el-icon-delete", size: "default", onClick: pe((m) => ae(e.row.id), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "expand-row-keys"]), o(ne, { class: "remark-detail", modelValue: k.value, "onUpdate:modelValue": t[2] || (t[2] = (e) => k.value = e), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 3, maxRows: 3 }, maxlength: "255", placeholder: "请填写备注", style: { width: "100%", "margin-top": "10px" } }, null, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]), o(n(Re), { ref_key: "choseDialogRef", ref: D, visible: I.value, "onUpdate:visible": t[4] || (t[4] = (e) => I.value = e), packType: r.value, packLoading: U.value, onHandlePack: K }, null, 8, ["visible", "packType", "packLoading"])], 64);
  };
} };
export {
  Ae as default
};
