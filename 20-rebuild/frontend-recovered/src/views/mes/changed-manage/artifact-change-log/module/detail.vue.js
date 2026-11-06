import { ref as b } from "vue";
import { watch as U } from "vue";
import { nextTick as B } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as o } from "vue";
import { createBlock as m } from "vue";
import { withCtx as l } from "vue";
import { createVNode as i } from "vue";
import { unref as t } from "vue";
import { createTextVNode as c } from "vue";
import { toDisplayString as d } from "vue";
import { createElementBlock as g } from "vue";
import { Fragment as $ } from "vue";
import { createCommentVNode as q } from "vue";
import { createElementVNode as J } from "vue";
import { isRef as Q } from "vue";
import { ElMessage as Y } from "element-plus";
import { ElTag as Z } from "element-plus";
import { ElDescriptionsItem as X } from "element-plus";
import { ElDescriptions as v } from "element-plus";
import { ElDivider as ee } from "element-plus";
import { a as te } from "../../../../../modules/artifact-change-log-d1afb1ca.js";
import { _ as ae, u as re, i as f, o as ne, mC as p, G as le, z as ie, p as oe, ai as h, n7 as se, D as A, Z as de, S as ue } from "../../../../../shared/runtime.js";
import { _ as y } from "../../../../../modules/index-61ce89a1.js";
const ce = { key: 1 }, me = { key: 1 }, fe = { key: 1 }, we = { key: 1 }, ge = { key: 1 }, he = { key: 1 }, ye = { key: 1 }, _e = { key: 1 }, be = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, permission: { type: Object, default: () => {
} }, currentRow: { type: Object, default: () => {
} }, uploadList: { type: Array, default: () => [] } }, emits: ["update:modelValue", "deleteModifyItem", "success"], setup(u, { emit: G }) {
  const E = G, N = u, { visible: T, handleClose: L } = re({ emit: E, props: N }), M = b(), V = b([]), F = b(), W = b(false);
  b();
  const C = b(false), I = b([]);
  U(T, async (_) => {
    _ && (V.value = [], W.value = true, await B(), setTimeout(() => {
      const n = /* @__PURE__ */ new Map(), k = /* @__PURE__ */ new Map();
      ["updateArtifactList", "delArtifactList"].forEach((r) => {
        const s = N.currentRow[r];
        f(s) && s.forEach((a) => {
          n.has(a.serialNumber) || n.set(a.serialNumber, { id: a.serialNumber, parentId: null, dataType: 1, serialNumber: a.serialNumber, name: a.name, printedCode: a.printedCode, grossWeight: a.grossWeight, length: a.length, material: a.material, netWeight: a.netWeight, specification: a.specification, surfaceArea: a.surfaceArea }), k.has(a.serialNumber + "_" + a.sortNumber) || k.set(a.serialNumber + "_" + a.sortNumber, { id: a.serialNumber + "_" + a.sortNumber, parentId: a.serialNumber, dataType: 2, modifyType: r === "updateArtifactList" ? 1 : 2, sortNumber: a.sortNumber, serialNumber: a.serialNumber + "(" + a.sortNumber + ")", name: a.name, printedCode: a.printedCode, grossWeight: a.grossWeight, length: a.length, material: a.material, netWeight: a.netWeight, specification: a.specification, surfaceArea: a.surfaceArea, newVal: r === "updateArtifactList" ? { serialNumber: a.changeSerialNumber, name: a.changeName, printedCode: a.changePrintedCode, grossWeight: a.changeGrossWeight, length: a.changeLength, material: a.changeMaterial, netWeight: a.changeNetWeight, specification: a.changeSpecification, surfaceArea: a.changeSurfaceArea } : {} });
        });
      });
      const w = N.currentRow.artifactBasicUpdateDTOList;
      f(w) && w.forEach((r) => {
        n.has(r.serialNumber) || n.set(r.serialNumber, { id: r.serialNumber, parentId: null, ...r, surfaceArea: r.surfaceArea / 1e6, modifyType: 1, dataType: 1, newVal: { quantity: r.changeQuantity || r.quantity, serialNumber: r.serialNumber, name: r.changeName, printedCode: r.changePrintedCode, grossWeight: r.changeGrossWeight, length: r.changeLength, material: r.material, netWeight: r.changeNetWeight, specification: r.specification, surfaceArea: r.changeSurfaceArea / 1e6 } });
      }), V.value = [...Array.from(n.values()), ...Array.from(k.values())], I.value = V.value.filter((r) => r.parentId === null).map((r) => r.id), B(() => {
        var s;
        const r = j(I.value);
        (s = M.value) == null || s.setTreeExpand(r, true);
      }), W.value = false;
    }, 4));
  }, { immediate: true, deep: true });
  const j = (_) => V.value.filter((n) => _.includes(n.id)), { maxHeight: z } = ne({ mainBox: ".inbound-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, F);
  async function S(_) {
    try {
      C.value = true;
      const n = { checkStatus: _, id: N.currentRow.id };
      await te(n), Y({ message: p.VL[_] + "成功", type: "success" }), E("success"), L();
    } catch (n) {
      console.log("构件变更", n);
    } finally {
      C.value = false;
    }
  }
  return (_, n) => {
    const k = Z, R = x("common-button"), w = X, r = v, s = x("vxe-column"), a = x("table-cell-tag"), H = x("vxe-table"), K = ee, P = x("common-drawer");
    return o(), m(P, { ref_key: "drawerRef", ref: F, title: "变更明细", "close-on-click-modal": false, modelValue: t(T), "onUpdate:modelValue": n[3] || (n[3] = (e) => Q(T) ? T.value = e : null), direction: "rtl", "before-close": t(L), "custom-class": "inbound-record", size: "85%" }, { titleAfter: l(() => {
      var e, D;
      return [i(k, { type: (D = t(p).V[(e = u.currentRow) == null ? void 0 : e.checkStatus]) == null ? void 0 : D.T }, { default: l(() => {
        var O;
        return [c(d(t(p).VL[(O = u.currentRow) == null ? void 0 : O.checkStatus]), 1)];
      }), _: 1 }, 8, ["type"])];
    }), titleRight: l(() => [u.currentRow.checkStatus === t(p).AUDITING.V && t(le)(u.permission.audit) ? (o(), g($, { key: 0 }, [i(R, { loading: C.value, type: "primary", size: "default", onClick: n[0] || (n[0] = (e) => S(t(p).PASS.V)) }, { default: l(() => n[4] || (n[4] = [c("通过")])), _: 1, __: [4] }, 8, ["loading"]), i(R, { loading: C.value, type: "warning", size: "default", onClick: n[1] || (n[1] = (e) => S(t(p).REJECT.V)) }, { default: l(() => n[5] || (n[5] = [c("驳回")])), _: 1, __: [5] }, 8, ["loading"])], 64)) : q("", true)]), content: l(() => [i(r, { class: "margin-top", column: 2, border: "" }, { default: l(() => [i(w, { "label-class-name": "contractLabel", label: "项目" }, { default: l(() => [c(d(t(ie)(u.currentRow.project)), 1)]), _: 1 }), i(w, { "label-class-name": "contractLabel", label: "单体" }, { default: l(() => {
      var e;
      return [c(d((e = u.currentRow.monomer) == null ? void 0 : e.name), 1)];
    }), _: 1 }), i(w, { "label-class-name": "contractLabel", label: "变更人" }, { default: l(() => [c(d(u.currentRow.user.name), 1)]), _: 1 }), i(w, { "label-class-name": "contractLabel", label: "日期" }, { default: l(() => [c(d(t(oe)(u.currentRow.createTime, "{y}-{m}-{d} {h}:{i}")), 1)]), _: 1 }), i(w, { "label-class-name": "contractLabel", label: "变更原因" }, { default: l(() => [c(d(u.currentRow.changeReason.name), 1)]), _: 1 }), i(w, { "label-class-name": "contractLabel", label: "描述" }, { default: l(() => [c(d(u.currentRow.remark), 1)]), _: 1 })]), _: 1 }), i(H, { border: "", "show-header-overflow": "", ref_key: "tableRef", ref: M, data: V.value, "max-height": t(z) - 280, loading: W.value, "loading-config": { text: "正在加载" }, "empty-text": "暂无数据", "column-config": { resizable: true }, "return-source-data": "", "scroll-y": { enabled: true, scrollToTopOnChange: true, gt: 0 }, "scroll-x": { enabled: true, scrollToLeftOnChange: true, gt: 0 }, "tree-config": { transform: true, rowField: "id", parentField: "parentId", expandAll: true }, "show-overflow": "tooltip", style: { margin: "20px 0" } }, { default: l(() => [i(s, { type: "seq", title: "序号", "tree-node": "", "row-resize": "", align: "center", width: "80" }), i(s, { field: "serialNumber", title: "构件编号", "min-width": "140px", "show-overflow": "" }, { default: l(({ row: e }) => [i(a, { show: !!e.modifyType, name: e.modifyType === 1 ? "修改" : "删除", color: e.modifyType === 1 ? "#67c23a" : "#f56c6c", offset: 20 }, null, 8, ["show", "name", "color"]), t(f)(e.newVal) && e.modifyType === 1 && !t(h)(e.serialNumber, e.newVal.serialNumber) ? (o(), m(t(y), { key: 0, old: e.serialNumber, new: e.newVal.serialNumber }, null, 8, ["old", "new"])) : (o(), g("span", ce, d(e.serialNumber), 1))]), _: 1 }), i(s, { key: "name", field: "name", "show-overflow": "", title: "名称", "min-width": "140px" }, { default: l((e) => [t(f)(e.row.newVal) && e.row.modifyType === 1 && !t(h)(e.row.name, e.row.newVal.name) ? (o(), m(t(y), { key: 0, old: e.row.name, new: e.row.newVal.name }, null, 8, ["old", "new"])) : (o(), g("span", me, d(e.row.name), 1))]), _: 1 }), u.currentRow.type === t(se).MODIFY_INFO.V ? (o(), m(s, { key: "quantity", field: "quantity", "show-overflow": "", title: "数量", align: "left", "min-width": "80px" }, { default: l((e) => [t(f)(e.row.newVal) && e.row.modifyType === 1 && !t(h)(e.row.quantity, e.row.newVal.quantity) ? (o(), m(t(y), { key: 0, old: e.row.quantity, new: e.row.newVal.quantity }, null, 8, ["old", "new"])) : (o(), g("span", fe, d(e.row.quantity || "-"), 1))]), _: 1 })) : q("", true), i(s, { key: "specification", field: "specification", "show-overflow": "", title: "规格", "min-width": "120" }, { default: l((e) => [c(d(e.row.specification ? e.row.specification : "-"), 1)]), _: 1 }), i(s, { key: "length", field: "length", "show-overflow": "", title: "长度(mm)", align: "left", "min-width": "90px" }, { default: l((e) => [t(f)(e.row.newVal) && e.row.modifyType === 1 && !t(h)(e.row.length, e.row.newVal.length) ? (o(), m(t(y), { key: 0, old: e.row.length, new: e.row.newVal.length }, null, 8, ["old", "new"])) : (o(), g("span", we, d(e.row.length ? e.row.length.toFixed(t(A).MES_ARTIFACT_L__MM) : "-"), 1))]), _: 1 }), i(s, { key: "netWeight", field: "netWeight", "show-overflow": "", title: "单净重(kg)", align: "left", "min-width": "90px" }, { default: l((e) => [t(f)(e.row.newVal) && e.row.modifyType === 1 && !t(h)(e.row.netWeight, e.row.newVal.netWeight) ? (o(), m(t(y), { key: 0, old: e.row.netWeight, new: e.row.newVal.netWeight }, null, 8, ["old", "new"])) : (o(), g("span", ge, d(e.row.netWeight ? e.row.netWeight.toFixed(t(A).COM_WT__KG) : "-"), 1))]), _: 1 }), i(s, { key: "grossWeight", field: "grossWeight", "show-overflow": "", title: "单毛重(kg)", align: "left", "min-width": "90px" }, { default: l((e) => [t(f)(e.row.newVal) && e.row.modifyType === 1 && !t(h)(e.row.grossWeight, e.row.newVal.grossWeight) ? (o(), m(t(y), { key: 0, old: e.row.grossWeight, new: e.row.newVal.grossWeight }, null, 8, ["old", "new"])) : (o(), g("span", he, d(e.row.grossWeight ? e.row.grossWeight.toFixed(t(A).COM_WT__KG) : "-"), 1))]), _: 1 }), i(s, { key: "surfaceArea", field: "surfaceArea", "show-overflow": "", title: "面积(㎡)", align: "left", "min-width": "80px" }, { default: l((e) => [t(f)(e.row.newVal) && e.row.modifyType === 1 && (e.row.surfaceArea && e.row.surfaceArea !== "-" || e.row.newVal.surfaceArea) && !t(h)(e.row.surfaceArea, e.row.newVal.surfaceArea) ? (o(), m(t(y), { key: 0, old: e.row.surfaceArea ? e.row.surfaceArea.toFixed(t(A).COM_AREA__M2) : "-", new: e.row.newVal.surfaceArea ? e.row.newVal.surfaceArea.toFixed(t(A).COM_AREA__M2) : "-" }, null, 8, ["old", "new"])) : (o(), g("span", ye, d(e.row.surfaceArea && e.row.surfaceArea !== "-" ? e.row.surfaceArea.toFixed(t(A).COM_AREA__M2) : "-"), 1))]), _: 1 }), i(s, { key: "material", field: "material", "show-overflow": "", title: "材质", align: "center", "min-width": "80px" }, { default: l((e) => [c(d(e.row.material || "-"), 1)]), _: 1 }), i(s, { key: "printedCode", align: "center", title: "喷印编码", "min-width": "140px", field: "printedCode", "show-overflow": "" }, { default: l((e) => [t(f)(e.row.newVal) && e.row.modifyType === 1 && !t(h)(e.row.printedCode, e.row.newVal.printedCode) ? (o(), m(t(y), { key: 0, new: e.row.newVal.printedCode, old: e.row.printedCode }, null, 8, ["new", "old"])) : (o(), g("span", _e, d(e.row.printedCode || "-"), 1))]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "loading"]), i(K, null, { default: l(() => n[6] || (n[6] = [J("span", { class: "title" }, "附件", -1)])), _: 1, __: [6] }), i(t(u.uploadList), { "show-download": "", "download-fn": t(de), uploadable: false, "file-classify": t(ue).ARTIFACT_CHANGE.V, files: u.currentRow.changeAttachmentList, "onUpdate:files": n[2] || (n[2] = (e) => u.currentRow.changeAttachmentList = e), "empty-text": "暂未上传变更附件" }, null, 8, ["download-fn", "file-classify", "files"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, xe = ae(be, [["__scopeId", "data-v-6aa3541c"]]);
export {
  xe as default
};
