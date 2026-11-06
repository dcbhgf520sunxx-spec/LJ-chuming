import { ref as y } from "vue";
import { computed as xe } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as S } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as w } from "vue";
import { withDirectives as W } from "vue";
import { unref as v } from "vue";
import { toDisplayString as L } from "vue";
import { createCommentVNode as ke } from "vue";
import { createElementBlock as Ce } from "vue";
import { isRef as _e } from "vue";
import { ElMessage as T } from "element-plus";
import { ElMessageBox as G } from "element-plus";
import { ElNotification as Ie } from "element-plus";
import { ElTableColumn as Pe } from "element-plus";
import { ElTag as Se } from "element-plus";
import { ElInput as Ve } from "element-plus";
import { vLoading as Le } from "element-plus";
import { x as Te, y as Ee, z as Re, A as De } from "../../../../../modules/artifact-tree-bcd3b733.js";
import { _ as Be, u as Qe, o as Me, tA as B, i as Ne, aw as J } from "../../../../../shared/runtime.js";
const Oe = { class: "machine-part-list" }, Ue = { class: "head" }, qe = { class: "bottom-title" }, Fe = { class: "head" }, Ae = { key: 1 }, $e = { __name: "PL-config", props: { visible: { type: Boolean, default: false }, rowData: { type: Object, default: () => {
} } }, emits: ["update:visible", "getComboList", "fetchAssemblyState"], setup(E, { emit: K }) {
  const x = E, Q = K, k = y(), M = y(), N = y(), I = y([]), f = y([]), h = y([]), X = y([]), C = y([]), V = y(false), { visible: R, handleClose: O } = Qe({ emit: Q, props: x, field: "visible", showHook: U, closeHook: he }), { maxHeight: Y } = Me({ mainBox: ".el-drawer", extraBox: ["machine-part-list", "el-drawer__header"], wrapperBox: [".el-drawer__body"] }, N);
  async function U() {
    V.value = true, re();
    try {
      const { techAssembleRecordDTO: t, techAssembleRecordNewDTO: e } = await Te({ artifactId: x.rowData.artifactId });
      I.value = t, f.value = e, f.value.forEach((o) => {
        F(o);
      }), X.value = [];
    } catch (t) {
      console.log(t);
    } finally {
      V.value = false;
    }
  }
  const q = xe(() => f.value.filter((t) => t.temporary)), Z = { flankPlateType: [{ required: true, message: "请选择翼腹板定义", trigger: "change" }] }, ee = { assembleConfigId: [{ required: true, message: "请选择构部件定义", trigger: "change" }], specPrefix: [{ required: true, message: "请选择截面类型", trigger: "change" }], unitQuantity: [{ required: true, message: "请输入数量", trigger: "blur" }], newSpecification: [{ required: true, message: "请输入规格", trigger: "blur" }] }, { tableValidate: te, wrongCellMask: ae } = J({ rules: Z, errorMsg: "请修正表格中标红的信息" }), { tableValidate: oe, wrongCellMask: le } = J({ rules: ee, errorMsg: "请修正表格中标红的信息" });
  function ne(t) {
    h.value = t;
  }
  function ie() {
    const { validResult: t, dealList: e } = te(h.value);
    if (t) h.value = e;
    else return t;
    if (h.value.length < 2) {
      T.error("至少选择两个零件再组合");
      return;
    }
    if (h.value.every((l, g) => l.flankPlateType === 1)) {
      T.error("不能全选择翼板类型");
      return;
    }
    if (h.value.every((l, g) => l.flankPlateType === 2)) {
      T.error("不能全选择腹板类型");
      return;
    }
    const r = Date.now().toString(36) + Math.random().toString(36).substring(2, 9), u = C.value.find((l) => {
      var g, m;
      return l.id === ((m = (g = C.value) == null ? void 0 : g[0]) == null ? void 0 : m.id);
    }), s = [], b = [];
    h.value.forEach((l, g) => {
      var m, a, d, A;
      l.comboId = r, l.temporary = true, l.assembleConfigId = (a = (m = C.value) == null ? void 0 : m[0]) == null ? void 0 : a.id, l.specPrefixList = (u == null ? void 0 : u.assembleSpecList.map((D) => ({ specPrefix: D }))) || [], l.specPrefix = (d = l.specPrefixList[0]) == null ? void 0 : d.specPrefix, l.flankPlateType === 1 && s.push(l), l.flankPlateType === 2 && b.push(l), setTimeout(() => {
        var $, z, j, H;
        const D = ($ = b[0]) != null && $.width ? parseFloat(b[0].width).toFixed(0) : "", we = (z = b[0]) != null && z.thick ? parseFloat(b[0].thick).toFixed(0) : "", ye = (j = s[0]) != null && j.width ? parseFloat(s[0].width).toFixed(0) : "", ve = (H = s[0]) != null && H.thick ? parseFloat(s[0].thick).toFixed(0) : "";
        l.newSpecification = D + "*" + ye + "*" + ve + "*" + we, l.unitQuantity = 1;
      }, 0), (A = M.value) == null || A.toggleRowSelection(l, true);
    }), f.value.push(...h.value), h.value.forEach((l, g) => {
      I.value.forEach((m, a) => {
        l.id === m.id && I.value.splice(a, 1);
      });
    });
  }
  async function re() {
    try {
      C.value = await Ee({ mesProductEnum: x.rowData.mesProductEnum });
    } catch (t) {
      console.log(t);
    }
  }
  function se(t) {
    G.confirm("是否确认删除？", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
      ce(t);
    }).catch(() => {
      console.log("删除失败");
    });
  }
  async function ce(t) {
    if (t.temporary) f.value.forEach((o, n) => {
      o.comboId === t.comboId && (o.flankPlateType = void 0, o.temporary = void 0, o.newSpecification = void 0, o.specPrefix = void 0, o.assembleConfigId = void 0, o.unitQuantity = void 0, I.value.push(o));
    }), f.value = f.value.filter((o) => o.comboId !== t.comboId);
    else {
      const o = f.value.filter((r) => r.comboId === t.comboId), n = [];
      o.forEach((r, u) => {
        const { comboId: s } = r;
        n[s] || (n[s] = { newSpecification: r.newSpecification, specPrefix: r.specPrefix, assembleConfigId: r.assembleConfigId, artifactId: x.rowData.artifactId, unitQuantity: +r.unitQuantity, techPartRecordVOList: [] }), n[s].techPartRecordVOList.push(r);
      });
      var e = Object.values(n);
      try {
        await Re({ techUnitRecordVOList: e }), T.success("删除成功"), U();
      } catch (r) {
        console.log(r);
      }
    }
  }
  async function de() {
    ue(q.value, true);
  }
  async function ue(t, e = false) {
    const { validResult: o, dealList: n } = oe(t);
    if (o) t = n;
    else return o;
    const r = [];
    t.forEach((s, b) => {
      const { comboId: l } = s;
      r[l] || (r[l] = { newSpecification: s.newSpecification, specPrefix: s.specPrefix, assembleConfigId: s.assembleConfigId, artifactId: x.rowData.artifactId, unitQuantity: +s.unitQuantity, techPartRecordVOList: [] }), r[l].techPartRecordVOList.push(s);
    });
    const u = Object.values(r);
    G.confirm(`是否确认${e ? "批量" : ""}保存？`, { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
      var s, b, l, g, m;
      await De({ artifactId: (s = x.rowData) == null ? void 0 : s.artifactId, artifactStructureClassId: (b = x.rowData) == null ? void 0 : b.newStructureClassId, artifactSpecPrefix: (l = x.rowData) == null ? void 0 : l.newSpecPrefix, assembleSpecPrefix: (g = u == null ? void 0 : u[0]) == null ? void 0 : g.specPrefix, assembleSpecification: (m = u == null ? void 0 : u[0]) == null ? void 0 : m.newSpecification, unitRecordVOList: u }), O(), Ie({ title: `${e ? "批量" : ""}保存成功`, type: "success", duration: 2500 });
    }).catch(() => {
      console.log("保存失败");
    });
  }
  function F(t) {
    const e = C.value.find((o) => o.id === (t == null ? void 0 : t.assembleConfigId));
    t.specPrefixList = (e == null ? void 0 : e.assembleSpecList.map((o) => ({ specPrefix: o }))) || [], f.value.forEach((o) => {
      o.comboId === t.comboId && (o.assembleConfigId = t.assembleConfigId);
    }), t.specPrefix = t.specPrefixList[0].specPrefix;
  }
  function pe(t, e) {
    var o, n;
    e ? (o = k == null ? void 0 : k.value) == null || o.toggleRowSelection(t, true) : (n = k == null ? void 0 : k.value) == null || n.toggleRowSelection(t, false);
  }
  function fe(t) {
    f.value.forEach((e) => {
      e.comboId === t.comboId && (e.specPrefix = t.specPrefix);
    });
  }
  function me(t) {
    f.value.forEach((e) => {
      e.comboId === t.comboId && (e.newSpecification = t.newSpecification);
    });
  }
  function be(t) {
    f.value.forEach((e) => {
      e.comboId === t.comboId && (e.unitQuantity = t.unitQuantity);
    });
  }
  function ge({ row: t, column: e, rowIndex: o, columnIndex: n }) {
    if (e.type === "selection" || e.property === "assembleConfigId" || e.property === "specPrefix" || e.property === "unitQuantity" || e.property === "newSpecification" || e.property === "operation") {
      const r = t.comboId || "", u = f.value[o - 1], s = u ? u.comboId : null;
      if (r === s) return { rowspan: 0, colspan: 0 };
      {
        let b = 1;
        for (let l = o + 1; l < f.value.length; l++) {
          const m = f.value[l].comboId || "";
          if (m && r && m === r) b++;
          else break;
        }
        return { rowspan: b, colspan: 1 };
      }
    }
  }
  function he() {
    Q("fetchAssemblyState");
  }
  return (t, e) => {
    const o = P("common-button"), n = Pe, r = P("common-select"), u = P("common-table"), s = Se, b = P("table-cell-tag"), l = Ve, g = P("common-drawer"), m = Le;
    return _(), S(g, { "append-to-body": "", ref_key: "drawerRef", ref: N, title: "翼腹板归类配置", modelValue: v(R), "onUpdate:modelValue": e[1] || (e[1] = (a) => _e(R) ? R.value = a : null), direction: "rtl", "before-close": v(O), size: "80%" }, { content: c(() => [p("div", Oe, [p("div", Ue, [e[3] || (e[3] = p("div", { class: "content-tips" }, "*提示：请对清单中翼腹板进行定义，定义后点击组合", -1)), i(o, { size: "default", type: "success", disabled: !h.value.length, onClick: ie }, { default: c(() => e[2] || (e[2] = [w(" 组合 ")])), _: 1, __: [2] }, 8, ["disabled"])]), W((_(), S(u, { ref_key: "tableRef", ref: k, data: I.value, "max-height": 300, "cell-class-name": v(ae), "return-source-data": "", showEmptySymbol: false, onSelectionChange: ne }, { default: c(() => [i(n, { key: "selection", type: "selection", width: "55" }), i(n, { type: "index", label: "序号", align: "center", width: "80" }), i(n, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", align: "center", label: "零件编号" }), i(n, { key: "specification", prop: "specification", "show-overflow-tooltip": "", align: "center", label: "规格", "min-width": "120" }), i(n, { key: "length", prop: "length", "show-overflow-tooltip": "", label: "长度(mm)", align: "center", "min-width": "90px" }), i(n, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "单构件数量", align: "center", "min-width": "90px" }), i(n, { key: "material", prop: "material", "show-overflow-tooltip": "", label: "材质", align: "center", "min-width": "90px" }), i(n, { key: "remark", prop: "remark", "show-overflow-tooltip": "", label: "备注", align: "center", "min-width": "90px" }, { default: c((a) => [p("span", null, L(a.row.remark || "-"), 1)]), _: 1 }), i(n, { key: "flankPlateType", prop: "flankPlateType", label: "*翼腹板定义", align: "center", "min-width": "200px" }, { header: c(() => e[4] || (e[4] = [p("span", { style: { color: "red" } }, "*", -1), w(" 翼腹板定义 ")])), default: c((a) => [i(r, { modelValue: a.row.flankPlateType, "onUpdate:modelValue": (d) => a.row.flankPlateType = d, options: v(B).ENUM, type: "enum", placeholder: "请选择翼腹板定义", style: { width: "270px" }, class: "filter-item", clearable: "", onChange: (d) => pe(a.row, d) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name"])), [[m, V.value]])]), p("div", null, [p("div", qe, [e[5] || (e[5] = p("span", { class: "title" }, " 部件组合信息", -1)), i(s, { size: "large", class: "filter-item" }, { default: c(() => [w("构件类型：" + L(E.rowData.newStructureClassLabel), 1)]), _: 1 }), i(s, { size: "large", class: "filter-item" }, { default: c(() => [w("构件截面：" + L(E.rowData.newSpecPrefix), 1)]), _: 1 })]), p("div", Fe, [e[7] || (e[7] = p("div", { class: "content-tips" }, "*提示：确认组合信息是否正确，否请删除，正确请确认", -1)), p("div", null, [i(o, { size: "default", type: "success", disabled: !q.value.length, onClick: e[0] || (e[0] = (a) => de()) }, { default: c(() => e[6] || (e[6] = [w(" 确认 ")])), _: 1, __: [6] }, 8, ["disabled"])])]), W((_(), S(u, { ref_key: "comboTableRef", ref: M, data: f.value, "cell-class-name": v(le), "max-height": v(Y), "return-source-data": "", showEmptySymbol: false, "span-method": ge }, { default: c(() => [i(n, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", align: "center", label: "零件编号" }, { default: c((a) => [a.row.serialNumber ? (_(), S(b, { key: 0, name: v(B).VL[a.row.flankPlateType], color: v(B).V[a.row.flankPlateType].COLOR, offset: 15 }, null, 8, ["name", "color"])) : ke("", true), p("span", null, L(a.row.serialNumber || "-"), 1)]), _: 1 }), i(n, { key: "specification", prop: "specification", "show-overflow-tooltip": "", align: "center", label: "规格", "min-width": "120px" }), i(n, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", align: "center", "min-width": "90px" }), i(n, { key: "length", prop: "length", "show-overflow-tooltip": "", label: "长度(mm)", align: "center", "min-width": "90px" }), i(n, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "单构件数量", align: "center" }), i(n, { key: "material", prop: "material", "show-overflow-tooltip": "", label: "材质", align: "center", "min-width": "90px" }), i(n, { key: "assembleConfigId", prop: "assembleConfigId", label: "构部件定义", align: "center", "min-width": "220px" }, { header: c(() => e[8] || (e[8] = [p("span", { style: { color: "red" } }, "*", -1), w(), p("span", null, "构部件定义", -1)])), default: c((a) => [i(r, { modelValue: a.row.assembleConfigId, "onUpdate:modelValue": (d) => a.row.assembleConfigId = d, options: C.value, dataStructure: { key: "id", label: "name", value: "id" }, placeholder: "选择类型", class: "filter-item", clearable: "", disabled: a.row.booInventory || !a.row.temporary, onChange: (d) => F(a.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled", "onChange"])]), _: 1 }), i(n, { key: "specPrefix", prop: "specPrefix", "show-overflow-tooltip": "", label: "截面", align: "left", "min-width": "90px" }, { header: c(() => e[9] || (e[9] = [p("span", { style: { color: "red" } }, "*", -1), w(" 截面 ")])), default: c((a) => [i(r, { modelValue: a.row.specPrefix, "onUpdate:modelValue": (d) => a.row.specPrefix = d, options: a.row.specPrefixList, disabled: !v(Ne)(a.row.specPrefixList) || a.row.booInventory || !a.row.temporary, type: "other", filterable: "", clearable: "", dataStructure: { key: "id", label: "specPrefix", value: "specPrefix" }, placeholder: "截面", onChange: (d) => fe(a.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled", "onChange"])]), _: 1 }), i(n, { key: "unitQuantity", prop: "unitQuantity", "show-overflow-tooltip": "", label: "数量", "min-width": "90px" }, { header: c(() => e[10] || (e[10] = [p("span", { style: { color: "red" } }, "*", -1), w(" 数量 ")])), default: c((a) => [i(l, { modelValue: a.row.unitQuantity, "onUpdate:modelValue": (d) => a.row.unitQuantity = d, modelModifiers: { trim: true }, oninput: "value=value.replace(/[^\\d]|^[0]/g, '')", placeholder: "输入数量", type: "text", maxlength: 30, disabled: a.row.booInventory || !a.row.temporary, onChange: (d) => be(a.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"])]), _: 1 }), i(n, { key: "newSpecification", prop: "newSpecification", "show-overflow-tooltip": "", label: "规格", "min-width": "120px" }, { header: c(() => e[11] || (e[11] = [p("span", { style: { color: "red" } }, "*", -1), w(" 规格 ")])), default: c((a) => [i(l, { modelValue: a.row.newSpecification, "onUpdate:modelValue": (d) => a.row.newSpecification = d, modelModifiers: { trim: true }, placeholder: "例如:400*200*10*12", type: "text", maxlength: 30, disabled: a.row.booInventory || !a.row.temporary, onChange: (d) => me(a.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"])]), _: 1 }), i(n, { label: "操作", prop: "operation", align: "center", width: "160px", fixed: "right" }, { default: c((a) => [a.row.booInventory ? (_(), Ce("span", Ae, " - ")) : (_(), S(o, { key: 0, size: "default", type: "danger", onClick: (d) => se(a.row) }, { default: c(() => e[12] || (e[12] = [w(" 删除 ")])), _: 2, __: [12] }, 1032, ["onClick"]))]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name", "max-height"])), [[m, V.value]])])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, We = Be($e, [["__scopeId", "data-v-1bc3b96a"]]);
export {
  We as default
};
