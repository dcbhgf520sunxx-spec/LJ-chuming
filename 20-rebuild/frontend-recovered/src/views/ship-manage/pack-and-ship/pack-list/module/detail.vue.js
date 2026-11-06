import { ref as k } from "vue";
import { inject as he } from "vue";
import { computed as ve } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as ke } from "vue";
import { openBlock as o } from "vue";
import { createBlock as u } from "vue";
import { createSlots as we } from "vue";
import { unref as r } from "vue";
import { withCtx as n } from "vue";
import { withDirectives as V } from "vue";
import { createTextVNode as f } from "vue";
import { createElementBlock as h } from "vue";
import { Fragment as N } from "vue";
import { createVNode as i } from "vue";
import { createCommentVNode as I } from "vue";
import { toDisplayString as g } from "vue";
import { renderList as K } from "vue";
import { withModifiers as xe } from "vue";
import { isRef as Ie } from "vue";
import { ElMessage as W } from "element-plus";
import { ElNotification as Le } from "element-plus";
import { ElPopconfirm as Te } from "element-plus";
import { ElDescriptionsItem as Ve } from "element-plus";
import { ElDescriptions as Ee } from "element-plus";
import { ElFormItem as Ce } from "element-plus";
import { ElForm as De } from "element-plus";
import { ElTableColumn as Ne } from "element-plus";
import { ElTag as Se } from "element-plus";
import { ElImage as Ue } from "element-plus";
import { ElInput as Me } from "element-plus";
import { vLoading as Re } from "element-plus";
import { d as Qe, a as Fe } from "../../../../../modules/pack-list-1d80c5dd.js";
import { e as ze } from "../../../../../modules/manual-pack-aab80853.js";
import { _ as Ae, u as Oe, o as je, V as A, bK as Be, z as Pe, p as He, K as G, bw as O, bi as j, bs as qe, D as Y, S as $e, Y as Ke, Z as We, O as Ge } from "../../../../../shared/runtime.js";
import { o as Ye } from "../../../../../modules/one-code-number-list-af2f89eb.js";
import { m as Xe } from "../../../../../modules/manuf-warehouse-select-bae65ecc.js";
import { _ as Ze } from "../../../../../modules/PicUpload-8580ccfc.js";
const Je = { key: 1 }, et = { key: 1 }, tt = { key: 1, class: "imgs-box" }, at = { key: 2 }, ot = { key: 1 }, nt = { __name: "detail", props: { visible: { type: Boolean, default: false }, detailInfo: { type: Object, required: true }, projectType: { type: Number } }, emits: ["update:visible", "del-success", "edit-success"], setup(_, { emit: X }) {
  const B = k(), S = X, L = _, { visible: U, handleClose: M } = Oe({ emit: S, props: L, field: "visible", showHook: te, closeHook: ae }), { maxHeight: Z } = je({ extraBox: [".el-drawer__header", ".other-content-top", ".other-content-bottom"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, () => B.value.loaded), R = he("permission"), E = k(false), w = k({}), v = k({}), x = k([]), P = k([]), p = k(false), Q = k(false), J = k([]), H = ve(() => L.detailInfo && L.detailInfo.id || void 0);
  function ee(e) {
    setTimeout(() => {
      const t = document.querySelector(".el-image-viewer__actions__inner");
      if (console.log(t), !document.querySelector(".el-icon-download")) {
        const d = document.createElement("i");
        d.className = "el-icon", d.addEventListener("click", function() {
          ue(e);
        }), d.innerHTML = `<i class="el-icon-download">
      <svg t="1729576815475" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5711" width="1em" height="1em"><path d="M450.56 820.48c4.48 4.48 10.88 7.04 16.64 8.96 3.84 1.92 8.32 2.56 12.8 2.56s8.96-0.64 12.8-2.56c6.4-1.28 12.16-3.84 16.64-8.96l313.6-313.6c14.08-14.08 14.08-35.84 0-49.92-14.08-14.08-35.84-14.08-49.92 0L512 718.08V160c0-17.92-14.08-32-32-32s-32 14.08-32 32v558.08L186.88 456.96c-14.08-14.08-35.84-14.08-49.92 0-14.08 14.08-14.08 35.84 0 49.92l313.6 313.6zM864 896H96c-17.92 0-32 14.08-32 32s14.08 32 32 32h768c17.92 0 32-14.08 32-32s-14.08-32-32-32z" p-id="5712"></path></svg>
     </i>`, t.appendChild(d);
      }
    }, 10);
  }
  function te() {
    re();
  }
  function ae() {
    p.value = false;
  }
  function oe() {
    p.value = true, w.value.warehouseId = v.value.warehouseId, w.value.remark = v.value.remark;
  }
  function ne() {
    p.value = false, x.value = A(P.value);
  }
  function le(e) {
    x.value.splice(e, 1);
  }
  function ie(e) {
    e.productQuantity = e.numberList.length, e.mete = +q(e);
  }
  function se(e, t) {
    var d;
    if (t.boolOneCode) {
      const l = ((d = t.originNumberList) == null ? void 0 : d.map((y) => y.number)) || [];
      t.numberList = l.slice(0, e);
    }
    t.mete = +q(t);
  }
  function q(e) {
    return L.projectType === G.BRIDGE.V ? e.productType === O.AUXILIARY_MATERIAL.V ? (e.originMete / e.packageQuantity * e.productQuantity).toFixed(2) : (e.grossWeight * e.productQuantity).toFixed(Y.COM_WT__KG) : e.productType === j.AUXILIARY_MATERIAL.V ? (e.originMete / e.packageQuantity * e.productQuantity).toFixed(2) : e.productType === j.ENCLOSURE.V ? (e.surfaceArea * e.productQuantity / 1e4).toFixed(2) : (e.grossWeight * e.productQuantity).toFixed(2);
  }
  async function re() {
    var e;
    try {
      E.value = true;
      const d = await Qe(H.value) || {};
      d.imgUrls = d.attachmentDTOS && ((e = d.attachmentDTOS) == null ? void 0 : e.map((l) => l.imageUrl)), v.value = d, x.value = d.detailsList.map((l) => {
        var y, c, b;
        return l.originNumberList = (y = l == null ? void 0 : l.numberList) != null && y.length ? A(l == null ? void 0 : l.numberList) : [], l.numberList = (b = (c = l.numberList) == null ? void 0 : c.filter((C) => C.boolPackage)) == null ? void 0 : b.map((C) => C.number), l.productQuantity = l.packageQuantity, l.originMete = l.mete, l;
      }), P.value = A(x.value);
    } catch (t) {
      console.log("详情", t);
    } finally {
      E.value = false;
    }
  }
  async function ue(e) {
    try {
      await Ke(We, { id: e == null ? void 0 : e.id }), W.success("下载成功");
    } catch (t) {
      console.log(t);
    }
  }
  const de = Ge(async function(e) {
    try {
      await Fe(e), Le({ title: "删除成功", type: "success", duration: 2500 }), S("del-success"), M();
    } catch (t) {
      console.log("删除打包清单", t);
    }
  }, 200, false);
  async function ce() {
    var e, t, d, l;
    try {
      Q.value = true;
      const y = { id: H.value, remark: w.value.remark, warehouseId: w.value.warehouseId, packageLinks: [], projectId: (e = L.detailInfo.project) == null ? void 0 : e.id, attachmentIds: ((d = (t = v.value) == null ? void 0 : t.attachmentDTOS) == null ? void 0 : d.map((c) => c.id)) || [] };
      for (let c = 0; c < ((l = x.value) == null ? void 0 : l.length); c++) {
        const b = x.value[c];
        y.packageLinks.push({ id: b.id, numberList: b.numberList, quantity: b.productQuantity, productType: b.productType });
      }
      await ze(y) && W({ type: "success", message: "更新打包清单成功" }), M(), S("edit-success");
    } catch (y) {
      console.log("编辑打包", y);
    } finally {
      Q.value = false;
    }
  }
  return (e, t) => {
    const d = T("print-table"), l = T("common-button"), y = Te, c = Ve, b = Ee, C = Ce, me = De, m = Ne, $ = Se, pe = T("table-cell-tag"), fe = T("common-input-number"), ye = T("common-table"), ge = Ue, _e = Me, be = T("common-drawer"), F = ke("permission"), z = Re;
    return o(), u(be, { ref_key: "drawerRef", ref: B, title: "打包清单", modelValue: r(U), "onUpdate:modelValue": t[4] || (t[4] = (a) => Ie(U) ? U.value = a : null), direction: "rtl", "before-close": r(M), size: "80%" }, we({ titleAfter: n(() => [p.value ? I("", true) : V((o(), u(d, { key: 0, "api-key": "mesPackingList", params: _.detailInfo.id, size: "default", type: "warning" }, null, 8, ["params"])), [[F, r(R).printPackList]])]), content: n(() => [V((o(), u(b, { class: "other-content-top", column: 2, border: "", style: { "margin-bottom": "10px" } }, { default: n(() => [i(c, { label: "项目" }, { default: n(() => [f(g(r(Pe)(_.detailInfo.project)), 1)]), _: 1 }), i(c, { label: "包单号" }, { default: n(() => [f(g(_.detailInfo.serialNumber), 1)]), _: 1 }), i(c, { label: "包单创建人" }, { default: n(() => [f(g(_.detailInfo.packerName), 1)]), _: 1 }), i(c, { label: "打包日期" }, { default: n(() => [f(g(r(He)(_.detailInfo.createTime)), 1)]), _: 1 }), i(c, { label: "存储位置" }, { default: n(() => {
      var a;
      return [p.value ? (o(), u(r(Xe), { key: 0, class: "input-border-none", modelValue: w.value.warehouseId, "onUpdate:modelValue": t[1] || (t[1] = (s) => w.value.warehouseId = s), style: { width: "100%" } }, null, 8, ["modelValue"])) : (o(), h("span", Je, g((a = _.detailInfo.warehouse) == null ? void 0 : a.name), 1))];
    }), _: 1 })]), _: 1 })), [[z, E.value]]), V((o(), u(ye, { "expand-row-keys": J.value, "default-expand-all": "", "row-key": "linkId", data: x.value || [], "max-height": r(Z), "return-source-data": "", "empty-text": "暂无数据", style: { width: "100%" } }, { default: n(() => [p.value ? (o(), u(m, { key: 0, type: "expand" }, { default: n(({ row: a }) => {
      var s;
      return [a.boolOneCode && ((s = a.originNumberList) != null && s.length) ? (o(), u(me, { key: 0, style: { "padding-top": "20px", "padding-left": "20px" } }, { default: n(() => [i(C, { label: "一物一码编号：" }, { default: n(() => [i(r(Ye), { modelValue: a.numberList, "onUpdate:modelValue": (D) => a.numberList = D, color: "#ffff00", list: a.originNumberList, "tag-width": 100, onChange: (D) => ie(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "list", "onChange"])]), _: 2 }, 1024)]), _: 2 }, 1024)) : I("", true)];
    }), _: 1 })) : I("", true), i(m, { label: "序号", type: "index", align: "center", width: "60" }), i(m, { "show-overflow-tooltip": true, prop: "monomer.name", label: "单体" }), i(m, { "show-overflow-tooltip": true, prop: "area.name", label: "区域" }), i(m, { "show-overflow-tooltip": true, prop: "productType", align: "center", label: "产品类型", width: "90" }, { default: n((a) => [L.projectType === r(G).BRIDGE.V ? (o(), u($, { key: 0, type: r(O).V[a.row.productType].T, effect: "plain", style: { "margin-right": "5px" } }, { default: n(() => [f(g(r(O).VL[a.row.productType]), 1)]), _: 2 }, 1032, ["type"])) : (o(true), h(N, { key: 1 }, K(r(j).ENUM, (s) => (o(), h(N, { key: s }, [a.row.productType & s.V ? (o(), u($, { key: 0, type: s.T, effect: "plain", style: { "margin-right": "5px" } }, { default: n(() => [f(g(s.L), 1)]), _: 2 }, 1032, ["type"])) : I("", true)], 64))), 128))]), _: 1 }), i(m, { "show-overflow-tooltip": true, prop: "name", label: "名称/类型" }, { default: n((a) => [a.row.warehouseType === 1 ? (o(), u(pe, { key: 0, name: "回厂返修", color: "#e64242", offset: 30 })) : I("", true), f(" " + g(a.row.name), 1)]), _: 1 }), i(m, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号" }), i(m, { "show-overflow-tooltip": true, prop: "specification", label: "规格" }), i(m, { "show-overflow-tooltip": true, prop: "length", label: "长度(mm)", align: "center" }, { default: n((a) => [f(g(r(qe)(a.row.length, r(Y).MES_ARTIFACT_L__MM)), 1)]), _: 1 }), i(m, { "show-overflow-tooltip": true, align: "center", prop: "measureUnit", label: "计量单位" }), i(m, { "show-overflow-tooltip": true, align: "center", prop: "productQuantity", label: "数量" }, { default: n(({ row: a }) => [p.value ? (o(), u(fe, { key: 0, modelValue: a.productQuantity, "onUpdate:modelValue": (s) => a.productQuantity = s, max: a.unPackageQuantity || a.inQuantity - a.packageQuantity, min: 1, step: 1, "controls-position": "right", size: "default", style: { width: "100%" }, onChange: (s) => se(s, a) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])) : (o(), h("span", et, g(a.productQuantity), 1))]), _: 1 }), i(m, { "show-overflow-tooltip": true, align: "center", prop: "accountingUnit", label: "核算单位" }), i(m, { "show-overflow-tooltip": true, align: "center", prop: "mete", label: "核算量" }), i(m, { "show-overflow-tooltip": true, align: "center", prop: "createUserNames", label: "打包人" }), p.value ? (o(), u(m, { key: 1, align: "center", fixed: "right", label: "操作", width: "70" }, { default: n(({ $index: a }) => [i(l, { icon: "el-icon-delete", size: "default", type: "danger", onClick: xe((s) => le(a), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : I("", true)]), _: 1 }, 8, ["expand-row-keys", "data", "max-height"])), [[z, E.value]]), V((o(), u(b, { class: "other-content-bottom", column: 1, border: "", style: { "margin-top": "10px" } }, { default: n(() => [i(c, { label: "附件" }, { default: n(() => {
      var a;
      return [p.value ? (o(), u(r(Ze), { key: 0, files: v.value.attachmentDTOS, "onUpdate:files": t[2] || (t[2] = (s) => v.value.attachmentDTOS = s), "file-classify": r($e).NORMAL.V, limit: 3, showDownloadBtn: "" }, null, 8, ["files", "file-classify"])) : ((a = v.value.attachmentDTOS) == null ? void 0 : a.length) > 0 ? (o(), h("div", tt, [(o(true), h(N, null, K(v.value.attachmentDTOS, (s) => {
        var D;
        return o(), h("div", { key: s.id, class: "imgs-box-item" }, [(o(), u(ge, { "preview-src-list": (D = v.value) == null ? void 0 : D.imgUrls, "initial-index": 1, key: s.id, src: s.tinyImageUrl, lazy: "", onShow: (lt) => ee(s) }, null, 8, ["preview-src-list", "src", "onShow"]))]);
      }), 128))])) : (o(), h("div", at, "-"))];
    }), _: 1 }), i(c, { label: "备注" }, { default: n(() => [p.value ? (o(), u(_e, { key: 0, modelValue: w.value.remark, "onUpdate:modelValue": t[3] || (t[3] = (a) => w.value.remark = a), modelModifiers: { trim: true }, autosize: { minRows: 3, maxRows: 3 }, class: "input-border-none", maxlength: "255", placeholder: "请填写备注", style: { width: "100%", "margin-top": "10px" }, type: "textarea" }, null, 8, ["modelValue"])) : (o(), h("span", ot, g(_.detailInfo.remark || "-"), 1))]), _: 1 })]), _: 1 })), [[z, E.value]])]), _: 2 }, [_.detailInfo.status === r(Be).UNENTRUCK.V ? { name: "titleRight", fn: n(() => [p.value ? (o(), h(N, { key: 1 }, [i(l, { type: "warning", size: "default", onClick: ne }, { default: n(() => t[6] || (t[6] = [f("取消编辑")])), _: 1, __: [6] }), i(l, { type: "success", size: "default", loading: Q.value, onClick: ce }, { default: n(() => t[7] || (t[7] = [f("保存")])), _: 1, __: [7] }, 8, ["loading"])], 64)) : V((o(), u(l, { key: 0, type: "primary", size: "default", onClick: oe }, { default: n(() => t[5] || (t[5] = [f("编辑")])), _: 1, __: [5] })), [[F, r(R).edit]]), p.value ? I("", true) : (o(), u(y, { key: 2, title: "确定要删除此条打包记录吗？", onConfirm: t[0] || (t[0] = (a) => r(de)(_.detailInfo.id)) }, { reference: n(() => [V((o(), u(l, { size: "default", type: "danger" }, { default: n(() => t[8] || (t[8] = [f(" 删除 ")])), _: 1, __: [8] })), [[F, r(R).del]])]), _: 1 }))]), key: "0" } : void 0]), 1032, ["modelValue", "before-close"]);
  };
} }, pt = Ae(nt, [["__scopeId", "data-v-e7b5d635"]]);
export {
  pt as default
};
