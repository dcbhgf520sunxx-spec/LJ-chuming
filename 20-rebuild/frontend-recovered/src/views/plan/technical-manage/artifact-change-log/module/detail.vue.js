import { ref as A } from "vue";
import { watch as U } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as i } from "vue";
import { createBlock as c } from "vue";
import { withCtx as n } from "vue";
import { createVNode as o } from "vue";
import { unref as t } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as D } from "vue";
import { withDirectives as z } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as $ } from "vue";
import { isRef as Q } from "vue";
import { ElMessage as Y } from "element-plus";
import { ElTag as Z } from "element-plus";
import { ElDescriptionsItem as J } from "element-plus";
import { ElDescriptions as X } from "element-plus";
import { ElTableColumn as v } from "element-plus";
import { ElDivider as ee } from "element-plus";
import { vLoading as ae } from "element-plus";
import { a as te } from "../../../../../modules/artifact-change-log-d1afb1ca.js";
import { _ as re, u as ne, i as f, o as le, mC as x, G as oe, z as ie, p as se, ai as b, n7 as de, D as N, Z as ue, S as ce } from "../../../../../shared/runtime.js";
import { _ as p } from "../../../../../modules/index-61ce89a1.js";
const me = { key: 1 }, we = { key: 1 }, fe = { key: 1 }, he = { key: 1 }, ge = { key: 1 }, ye = { key: 1 }, be = { key: 1 }, pe = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, permission: { type: Object, default: () => {
} }, currentRow: { type: Object, default: () => {
} }, uploadList: { type: Array, default: () => [] } }, emits: ["update:modelValue", "deleteModifyItem", "success"], setup(d, { emit: F }) {
  const R = F, _ = d, { visible: V, handleClose: L } = ne({ emit: R, props: _ }), h = A([]), E = A(), I = A(false), q = A(), T = A(false), W = A([]);
  U(V, (k) => {
    if (k) {
      h.value = [], W.value = [];
      const l = ["updateArtifactList", "delArtifactList"];
      for (let r = 0; r < l.length; r++) f(_.currentRow[l[r]]) && _.currentRow[l[r]].forEach((a) => {
        if (h.value.findIndex((u) => u.rowKey === a.serialNumber) < 0) {
          const u = { dataType: 1, serialNumber: a.serialNumber, name: a.name, printedCode: a.printedCode, rowKey: a.serialNumber, grossWeight: a.grossWeight, length: a.length, material: a.material, netWeight: a.netWeight, specification: a.specification, surfaceArea: a.surfaceArea, children: [{ dataType: 2, modifyType: l[r] === "updateArtifactList" ? 1 : 2, sortNumber: a.sortNumber, rowKey: a.serialNumber + "_" + a.sortNumber, serialNumber: a.serialNumber + "(" + a.sortNumber + ")", name: a.name, printedCode: a.printedCode, grossWeight: a.grossWeight, length: a.length, material: a.material, netWeight: a.netWeight, specification: a.specification, surfaceArea: a.surfaceArea, newVal: l[r] === "updateArtifactList" ? { serialNumber: a.changeSerialNumber, name: a.changeName, printedCode: a.changePrintedCode, grossWeight: a.changeGrossWeight, length: a.changeLength, material: a.changeMaterial, netWeight: a.changeNetWeight, specification: a.changeSpecification, surfaceArea: a.changeSurfaceArea } : {} }] };
          W.value.push(u.rowKey), h.value.push({ ...u });
        } else {
          const u = h.value.find((g) => g.rowKey === a.serialNumber) || {};
          if (f(u) && u.children.findIndex((g) => g.sortNumber === a.sortNumber) < 0) {
            const g = { dataType: 2, modifyType: l[r] === "updateArtifactList" ? 1 : 2, sortNumber: a.sortNumber, serialNumber: a.serialNumber + "(" + a.sortNumber + ")", rowKey: a.serialNumber + "_" + a.sortNumber, name: a.name, printedCode: a.printedCode, grossWeight: a.grossWeight, length: a.length, material: a.material, netWeight: a.netWeight, specification: a.specification, surfaceArea: a.surfaceArea, newVal: l[r] === "updateArtifactList" ? { serialNumber: a.changeSerialNumber, name: a.changeName, printedCode: a.changePrintedCode, grossWeight: a.changeGrossWeight, length: a.changeLength, material: a.changeMaterial, netWeight: a.changeNetWeight, specification: a.changeSpecification, surfaceArea: a.changeSurfaceArea } : {} };
            u.children.push({ ...g });
          }
        }
      });
      f(_.currentRow.artifactBasicUpdateDTOList) && _.currentRow.artifactBasicUpdateDTOList.map((r) => {
        h.value.push({ ...r, surfaceArea: r.surfaceArea / 1e6, rowKey: r.serialNumber, modifyType: 1, dataType: 1, children: [], newVal: { quantity: r.changeQuantity || r.quantity, serialNumber: r.serialNumber, name: r.name, printedCode: r.changePrintedCode, grossWeight: r.changeGrossWeight, length: r.changeLength, material: r.material, netWeight: r.changeNetWeight, specification: r.specification, surfaceArea: r.changeSurfaceArea / 1e6 } });
      });
    }
    console.log("构件变更", h.value);
  }, { immediate: true, deep: true });
  const { maxHeight: B } = le({ mainBox: ".inbound-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, E);
  async function K(k) {
    try {
      T.value = true;
      const l = { checkStatus: k, id: _.currentRow.id };
      await te(l), Y({ message: "撤销成功", type: "success" }), R("success"), L();
    } catch (l) {
      console.log("构件变更", l);
    } finally {
      T.value = false;
    }
  }
  return (k, l) => {
    const r = Z, a = C("common-button"), u = J, g = X, m = v, O = C("table-cell-tag"), G = C("common-table"), j = ee, H = C("common-drawer"), P = ae;
    return i(), c(H, { ref_key: "drawerRef", ref: E, modelValue: t(V), "onUpdate:modelValue": l[2] || (l[2] = (e) => Q(V) ? V.value = e : null), "before-close": t(L), "close-on-click-modal": false, "custom-class": "inbound-record", direction: "rtl", size: "85%", title: "变更明细" }, { titleAfter: n(() => {
      var e, M;
      return [o(r, { type: (M = t(x).V[(e = d.currentRow) == null ? void 0 : e.checkStatus]) == null ? void 0 : M.T }, { default: n(() => {
        var S;
        return [w(s(t(x).VL[(S = d.currentRow) == null ? void 0 : S.checkStatus]), 1)];
      }), _: 1 }, 8, ["type"])];
    }), titleRight: n(() => [d.currentRow.checkStatus === t(x).AUDITING.V && t(oe)(d.permission.cancel) ? (i(), c(a, { key: 0, loading: T.value, size: "default", type: "warning", onClick: l[0] || (l[0] = (e) => K(t(x).CANCEL.V)) }, { default: n(() => l[3] || (l[3] = [w(" 撤销 ")])), _: 1, __: [3] }, 8, ["loading"])) : D("", true)]), content: n(() => [o(g, { column: 2, border: "", class: "margin-top" }, { default: n(() => [o(u, { label: "项目", "label-class-name": "contractLabel" }, { default: n(() => [w(s(t(ie)(d.currentRow.project)), 1)]), _: 1 }), o(u, { label: "单体", "label-class-name": "contractLabel" }, { default: n(() => {
      var e;
      return [w(s((e = d.currentRow.monomer) == null ? void 0 : e.name), 1)];
    }), _: 1 }), o(u, { label: "变更人", "label-class-name": "contractLabel" }, { default: n(() => [w(s(d.currentRow.user.name), 1)]), _: 1 }), o(u, { label: "日期", "label-class-name": "contractLabel" }, { default: n(() => [w(s(t(se)(d.currentRow.createTime, "{y}-{m}-{d} {h}:{i}")), 1)]), _: 1 }), o(u, { label: "变更原因", "label-class-name": "contractLabel" }, { default: n(() => [w(s(d.currentRow.changeReason.name), 1)]), _: 1 }), o(u, { label: "描述", "label-class-name": "contractLabel" }, { default: n(() => [w(s(d.currentRow.remark), 1)]), _: 1 })]), _: 1 }), z((i(), c(G, { ref_key: "serialNumberRef", ref: q, data: h.value, "expand-row-keys": W.value, "max-height": t(B) - 280, "default-expand-all": "", "return-source-data": "", "row-key": "rowKey", style: { margin: "20px 0" } }, { default: n(() => [o(m, { align: "center", label: "序号", type: "index", width: "80" }), o(m, { key: "serialNumber", label: "构件编号", "min-width": "140px", prop: "serialNumber", "show-overflow-tooltip": "" }, { default: n((e) => [o(O, { color: e.row.modifyType === 1 ? "#67c23a" : "#f56c6c", name: e.row.modifyType === 1 ? "修改" : "删除", offset: 20, show: !!e.row.modifyType }, null, 8, ["color", "name", "show"]), t(f)(e.row.newVal) && e.row.modifyType === 1 && !t(b)(e.row.serialNumber, e.row.newVal.serialNumber) ? (i(), c(t(p), { key: 0, new: e.row.newVal.serialNumber, old: e.row.serialNumber }, null, 8, ["new", "old"])) : (i(), y("span", me, s(e.row.serialNumber), 1))]), _: 1 }), o(m, { key: "name", label: "名称", "min-width": "140px", prop: "name", "show-overflow-tooltip": "" }, { default: n((e) => [t(f)(e.row.newVal) && e.row.modifyType === 1 && !t(b)(e.row.name, e.row.newVal.name) ? (i(), c(t(p), { key: 0, new: e.row.newVal.name, old: e.row.name }, null, 8, ["new", "old"])) : (i(), y("span", we, s(e.row.name), 1))]), _: 1 }), d.currentRow.type === t(de).MODIFY_INFO.V ? (i(), c(m, { key: "quantity", align: "left", label: "数量", "min-width": "80px", prop: "quantity", "show-overflow-tooltip": "" }, { default: n((e) => [t(f)(e.row.newVal) && e.row.modifyType === 1 && !t(b)(e.row.quantity, e.row.newVal.quantity) ? (i(), c(t(p), { key: 0, new: e.row.newVal.quantity, old: e.row.quantity }, null, 8, ["new", "old"])) : (i(), y("span", fe, s(e.row.quantity || "-"), 1))]), _: 1 })) : D("", true), o(m, { key: "specification", label: "规格", "min-width": "120", prop: "specification", "show-overflow-tooltip": "" }, { default: n((e) => [w(s(e.row.specification ? e.row.specification : "-"), 1)]), _: 1 }), o(m, { key: "length", align: "left", label: "长度(mm)", "min-width": "90px", prop: "length", "show-overflow-tooltip": "" }, { default: n((e) => [t(f)(e.row.newVal) && e.row.modifyType === 1 && !t(b)(e.row.length, e.row.newVal.length) ? (i(), c(t(p), { key: 0, new: e.row.newVal.length, old: e.row.length }, null, 8, ["new", "old"])) : (i(), y("span", he, s(e.row.length ? e.row.length.toFixed(t(N).MES_ARTIFACT_L__MM) : "-"), 1))]), _: 1 }), o(m, { key: "netWeight", align: "left", label: "单净重(kg)", "min-width": "90px", prop: "netWeight", "show-overflow-tooltip": "" }, { default: n((e) => [t(f)(e.row.newVal) && e.row.modifyType === 1 && !t(b)(e.row.netWeight, e.row.newVal.netWeight) ? (i(), c(t(p), { key: 0, new: e.row.newVal.netWeight, old: e.row.netWeight }, null, 8, ["new", "old"])) : (i(), y("span", ge, s(e.row.netWeight ? e.row.netWeight.toFixed(t(N).COM_WT__KG) : "-"), 1))]), _: 1 }), o(m, { key: "surfaceArea", label: "面积(㎡)", align: "left", "min-width": "80px", prop: "surfaceArea", "show-overflow-tooltip": "" }, { default: n((e) => [t(f)(e.row.newVal) && e.row.modifyType === 1 && (e.row.surfaceArea && e.row.surfaceArea !== "-" || e.row.newVal.surfaceArea) && !t(b)(e.row.surfaceArea, e.row.newVal.surfaceArea) ? (i(), c(t(p), { key: 0, new: e.row.newVal.surfaceArea ? e.row.newVal.surfaceArea.toFixed(t(N).COM_AREA__M2) : "-", old: e.row.surfaceArea ? e.row.surfaceArea.toFixed(t(N).COM_AREA__M2) : "-" }, null, 8, ["new", "old"])) : (i(), y("span", ye, s(e.row.surfaceArea && e.row.surfaceArea !== "-" ? e.row.surfaceArea.toFixed(t(N).COM_AREA__M2) : "-"), 1))]), _: 1 }), o(m, { key: "material", align: "center", label: "材质", "min-width": "80px", prop: "material", "show-overflow-tooltip": "" }, { default: n((e) => [w(s(e.row.material || "-"), 1)]), _: 1 }), o(m, { key: "printedCode", align: "center", label: "喷印编码", "min-width": "140px", prop: "printedCode", "show-overflow-tooltip": "" }, { default: n((e) => [t(f)(e.row.newVal) && e.row.modifyType === 1 && !t(b)(e.row.printedCode, e.row.newVal.printedCode) ? (i(), c(t(p), { key: 0, new: e.row.newVal.printedCode, old: e.row.printedCode }, null, 8, ["new", "old"])) : (i(), y("span", be, s(e.row.printedCode), 1))]), _: 1 })]), _: 1 }, 8, ["data", "expand-row-keys", "max-height"])), [[P, I.value]]), o(j, null, { default: n(() => l[4] || (l[4] = [$("span", { class: "title" }, "附件", -1)])), _: 1, __: [4] }), o(t(d.uploadList), { files: d.currentRow.changeAttachmentList, "onUpdate:files": l[1] || (l[1] = (e) => d.currentRow.changeAttachmentList = e), "download-fn": t(ue), "file-classify": t(ce).ARTIFACT_CHANGE.V, uploadable: false, "empty-text": "暂未上传变更附件", "show-download": "" }, null, 8, ["files", "download-fn", "file-classify"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ke = re(pe, [["__scopeId", "data-v-64fee640"]]);
export {
  ke as default
};
