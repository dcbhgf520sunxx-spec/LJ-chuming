import { ref as i } from "vue";
import { watch as Ve } from "vue";
import { onMounted as De } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as Se } from "vue";
import { createElementBlock as $e } from "vue";
import { createVNode as l } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as b } from "vue";
import { unref as V } from "vue";
import { createElementVNode as z } from "vue";
import { normalizeClass as j } from "vue";
import { withDirectives as Y } from "vue";
import { vShow as K } from "vue";
import { toDisplayString as P } from "vue";
import { withModifiers as J } from "vue";
import { isRef as xe } from "vue";
import { Fragment as Ne } from "vue";
import { ElMessage as Re } from "element-plus";
import { ElMessageBox as Oe } from "element-plus";
import { ElNotification as Q } from "element-plus";
import { ElCascader as Ue } from "element-plus";
import { ElFormItem as qe } from "element-plus";
import { ElDatePicker as Pe } from "element-plus";
import { ElForm as Fe } from "element-plus";
import { ElDescriptionsItem as Me } from "element-plus";
import { ElDescriptions as Be } from "element-plus";
import { ElTableColumn as Ae } from "element-plus";
import { ElInput as Ge } from "element-plus";
import { l as ee, _ as We, qO as F, J as He, u as ze, o as je, cf as X, oS as Ye, a as Ke, qw as Z, qS as Je, er as Qe, qU as Xe, f9 as Ze, qV as et, ba as tt } from "../../../../../shared/runtime.js";
import at from "./materials-drawer.vue.js";
import lt from "./stock.vue.js";
import "./binding-detail.vue.js";
function ot(p) {
  return ee({ module: "mes", url: "team/partCutConfigTeamList/partCutConfigTeamFeatureList", method: "post", data: p });
}
function nt(p) {
  return ee({ module: "mes", url: "team/partCutConfigTeamList/cutTypeFeature", method: "post", data: p });
}
const it = { class: "head-container" }, st = { __name: "preview", props: { visible: { type: Boolean, default: false }, list: { type: Array, default: () => [] }, taskOrderIds: { type: Array, default: () => [] } }, emits: ["update:visible", "success", "handleDel", "handleBatchDel"], setup(p, { emit: te }) {
  const v = te, u = p, _ = { PRODUCE: { L: "生产工单", K: "NORMAL", V: 1 }, DRILL: { L: "原材料清单", K: "OFFLINE", V: 2 } }, M = i(), D = i(_.PRODUCE.V);
  i(true);
  const S = i([]), B = i([]), A = i([]), C = i(false), d = i(false), w = i(), k = i(), g = i(), f = i([]), ae = i(F.NESTING_ISSUED.V), G = i(false), $ = i(false), x = i([]), T = i();
  let N = {}, W = [];
  const H = i({}), le = { productionLineId: [{ required: true, message: "请选择生产班组", trigger: "blur" }], cutConfigId: [{ required: true, message: "请选择切割方式", trigger: "blur" }], askCompleteTime: [{ required: true, message: "请选择排产日期", trigger: "blur" }] };
  function oe(t) {
    const e = /* @__PURE__ */ new Map();
    return t.forEach((a) => {
      a = { ...a, quantity: Number(a.quantity), weight: parseFloat((a.weight * a.quantity).toFixed(3)), length: parseFloat((a.length * a.quantity).toFixed(3)) };
      const n = `${a.partType}-${a.specification}-${a.material}`;
      if (e.has(n)) {
        const r = e.get(n);
        r.quantity = (r.quantity || 0) + (a.quantity || 0), r.weight = parseFloat(((r.weight || 0) + (a.weight || 0)).toFixed(3)), r.length = parseFloat(((r.length || 0) + (a.length || 0)).toFixed(3));
      } else e.set(n, { ...a, wastageRate: 1, materialLength: 0 });
    }), Array.from(e.values());
  }
  const ne = (t) => {
    H.value = t, $.value = true;
  }, { handleSizeChange: rt, handleCurrentChange: ut, total: ct, setTotalPage: ie, queryPage: R } = He({ fetchHook: U }), se = (t, e, a) => {
    const n = t.match(/\d*\.?\d{0,5}/);
    n ? e.wastageRate = n[0] : e.wastageRate = "";
  }, { visible: I, handleClose: O } = ze({ emit: v, props: u, field: "visible", showHook: pe, closeHook: () => {
    D.value = _.PRODUCE.V;
  } }), { maxHeight: re } = je({ navbar: false, paginate: true }, I);
  function U() {
    var a;
    const t = (R.pageNumber - 1) * R.pageSize, e = t + R.pageSize;
    ie(u.list.length), x.value = (a = oe(u.list)) == null ? void 0 : a.slice(t, e);
  }
  function ue(t) {
    const e = u.list.filter((a) => `${a.partType}-${a.specification}-${a.material}` == `${t.partType}-${t.specification}-${t.material}`);
    v("handleBatchDel", { list: e, type: 1 });
  }
  const ce = () => {
    const t = u.list.filter((e) => S.value.some((a) => `${a.partType}-${a.specification}-${a.material}` == `${e.partType}-${e.specification}-${e.material}`));
    v("handleBatchDel", { list: t, type: 1 });
  };
  function de(t) {
    var e;
    return t > ((e = u.list[0]) == null ? void 0 : e.askCompleteTime);
  }
  function pe() {
    var t;
    w.value = (t = u.list[0]) == null ? void 0 : t.askCompleteTime, g.value = void 0, k.value = void 0, ye(), U(), ae.value = F.NESTING_ISSUED.V, W = Array.from(new Set(u.list.map((e) => e.partTypeId)));
  }
  const me = async (t) => {
    T.value = M.value.getCheckedNodes()[0].pathValues[0];
    try {
      const e = await nt({ partType: Z.MODEL.V, processType: X.MAKINGS.V, teamId: t, partFeatureList: W });
      A.value = e.map((a) => ({ name: a.deviceTypeName, id: a.id }));
    } catch (e) {
      console.log(e);
    }
  }, ge = (t) => {
    C.value = true, f.value = t.bindingData, N = { projectId: u.list[0].project.id, outboundAddress: Je.FACTORY.V }, N.list = t.bindingData.map((e) => ({ id: e.id, workshopId: e.workshopId, quantity: e.addNumber, outboundUnit: e.measureUnit, outboundUnitPrecision: e.accountingPrecision, outboundUnitType: e.outboundUnitType }));
  };
  function fe(t) {
    S.value = t;
  }
  const he = i([]);
  Ve(() => u.list, (t, e) => {
    t.length > e.length && (C.value = false), t.length === 0 && (f.value = [], C.value = false), U(), _e(u.list);
  });
  const y = i([]);
  async function ye() {
    var t;
    y.value = [];
    try {
      let e = [];
      e = await ot({ processType: X.MAKINGS.V, partType: Ye.PROFILE_PART.V }), y.value = ((t = e.mesBuildingPartCutConfigWorkShopDTOList) == null ? void 0 : t.map((a) => {
        var n;
        return a.name = a.workshopName, a.id = a.workshopId, a.children = ((n = a.mesBuildingPartCutConfigLineDTOList) == null ? void 0 : n.map((r) => {
          var L;
          return r.name = r.productionLineName, r.id = r.productionLineId, r.children = ((L = r.mesBuildingPartCutConfigTeamDTOList) == null ? void 0 : L.map((m) => (m.name = `${m.teamName}${m.deviceTypeName ? "(" + m.deviceTypeName + ")" : ""}`, m))) || [], r;
        })) || [], a;
      })) || [];
    } catch (e) {
      console.log("获取生产组的信息失败", e);
    }
  }
  async function be() {
    try {
      const { content: t } = await Qe({});
      t.forEach((e) => {
        e.children = e.workshopList;
      }), he.value = t[0].children;
    } catch {
      console.log("请求工厂-车间-生产线的层级接口失败");
    }
  }
  De(() => be());
  async function ve() {
    if (!g.value) return Re.warning("必选项不能为空"), false;
    const t = [];
    try {
      B.value = [], u.list.forEach((e) => {
        var a;
        B.value.push(e), t.push({ specification: e.specification, projectId: e.project.id, quantity: e.quantity, productId: e.productId, id: e.id, orderId: e.orderId, needSchedulingMonth: e.askCompleteTime, wastageRate: (a = x.value.find((n) => `${n.partType}-${n.specification}-${n.material}` == `${e.partType}-${e.specification}-${e.material}`)) == null ? void 0 : a.wastageRate });
      }), Oe.confirm("是否直接下发排产任务？", "温馨提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "primary", closeOnClickModal: false }).then(async () => {
        d.value = true;
        const e = await Xe({ productionLineId: g.value, productClassificationEnum: Ze.SECTION_PRODUCT.V, thick: String(Math.max(...u.list.map((a) => a.thick))), boolOffLine: et.NORMAL.V, linkList: t, askCompleteTime: w.value, cutConfigId: k.value, projectId: u.list[0].project.id, saveType: F.UN_NESTING_ISSUED.V, batchOutboundDTOParam: { ...N, workshopId: T.value, basicClass: Z.MODEL.V } });
        Q({ title: "型材排产下发成功", type: "success", duration: 2500 }), v("success"), d.value = false, C.value = false, f.value = [], O();
      }).catch(() => {
        d.value = false, Q({ title: "本次下发作废", type: "info", duration: 2500 });
      });
    } catch (e) {
      d.value = false, console.log("保存型材排产报错", e);
    } finally {
      d.value = false;
    }
  }
  function _e(t) {
    const e = [];
    t.forEach((n) => {
      e.includes(`${n.thick}_${n.material}`) || e.push(`${n.thick}_${n.material}`);
    });
    const a = f.value.map((n) => e.includes(n.key) ? n : null);
    f.value = a.filter((n) => n !== null);
  }
  function Ce(t) {
    return tt(t, { props: ["quantity"] });
  }
  return (t, e) => {
    const a = E("common-button"), n = Ue, r = qe, L = E("common-select"), m = Pe, we = Fe, ke = Me, Te = Be, c = Ae, Ie = Ge, Le = E("common-table"), Ee = E("common-drawer");
    return Se(), $e(Ne, null, [l(Ee, { customClass: "machine-part-scheduling-preview-dlg", title: "生产清单", modelValue: V(I), "onUpdate:modelValue": e[3] || (e[3] = (o) => xe(I) ? I.value = o : null), size: "80%", "before-close": V(O), showClose: false, closeOnClickModal: false }, { titleAfter: s(() => e[6] || (e[6] = [])), titleRight: s(() => {
      var o;
      return [l(a, { onClick: ve, loading: d.value, disabled: !((o = u.list) != null && o.length), type: "success" }, { default: s(() => e[7] || (e[7] = [b(" 任务下发 ")])), _: 1, __: [7] }, 8, ["loading", "disabled"]), l(a, { onClick: V(O), type: "info", loading: d.value }, { default: s(() => e[8] || (e[8] = [b(" 关闭 ")])), _: 1, __: [8] }, 8, ["onClick", "loading"])];
    }), content: s(() => [z("div", it, [l(we, { style: { display: "flex", "flex-wrap": "wrap" }, rules: le }, { default: s(() => [l(r, { label: "班组:", class: "form-label-require" }, { default: s(() => [l(n, { ref_key: "cascader", ref: M, modelValue: g.value, "onUpdate:modelValue": e[0] || (e[0] = (o) => g.value = o), options: y.value, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": false, separator: " > ", style: { width: "200px" }, filterable: "", placeholder: "请选择班组", class: "filter-item", disabled: d.value, onChange: me }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), l(r, { label: "切割方式:", class: j("form-label-require") }, { default: s(() => [l(L, { modelValue: k.value, "onUpdate:modelValue": e[1] || (e[1] = (o) => k.value = o), options: A.value, class: "filter-item", "data-structure": { key: "id", label: "name", value: "id" }, placeholder: "选择切割方式", disabled: !g.value, style: { width: "200px" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), l(r, { label: "完成日期:", class: j("form-label-require") }, { default: s(() => [l(m, { modelValue: w.value, "onUpdate:modelValue": e[2] || (e[2] = (o) => w.value = o), type: "date", class: "date-item filter-item", style: { width: "200px" }, placeholder: "选择完成日期", clearable: false, format: "YYYY-MM-DD", "value-format": "x", disabled: d.value, "disabled-date": de }, null, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 })]), Y(l(a, { type: "danger", icon: "el-icon-delete", disabled: !S.value.length, style: { float: "right", "margin-bottom": "10px" }, onClick: ce }, { default: s(() => e[9] || (e[9] = [b(" 批量删除 ")])), _: 1, __: [9] }, 8, ["disabled"]), [[K, D.value === _.PRODUCE.V]]), Y(l(Te, { border: "", style: { "margin-bottom": "10px" } }, { default: s(() => [l(ke, { label: "项目：", "label-align": "center", align: "left" }, { default: s(() => {
      var o, h;
      return [b(P(p.list.length ? `${(o = p.list[0].project) == null ? void 0 : o.serialNumber}${(h = p.list[0].project) == null ? void 0 : h.shortName}` : "-"), 1)];
    }), _: 1 })]), _: 1 }, 512), [[K, D.value === _.DRILL.V]]), l(Le, { data: x.value, "return-source-data": "", "max-height": V(re), style: { width: "100%" }, id: "listTables", showEmptySymbol: false, "summary-method": Ce, onSelectionChange: fe }, { default: s(() => [l(c, { type: "selection", width: "55" }), l(c, { label: "序号", type: "index", align: "center", width: "55" }), l(c, { key: "partType", prop: "partType", label: "类型", align: "center" }), l(c, { key: "specification", prop: "specification", label: "规格", align: "center", width: "200", "show-overflow-tooltip": true }), l(c, { key: "material", prop: "material", label: "材质", align: "center", width: "120", "show-overflow-tooltip": true }), l(c, { key: "quantity", prop: "quantity", label: "零件数量", align: "center" }), l(c, { key: "weight", prop: "weight", label: "零件重量(kg)", align: "center" }), l(c, { key: "length", prop: "length", label: "清单长度(m)", align: "center" }, { default: s(({ row: o }) => [b(P(o.length / 1e3), 1)]), _: 1 }), l(c, { key: "wastageRate", prop: "wastageRate", label: "损耗系数", align: "center" }, { default: s(({ row: o, $index: h }) => [l(Ie, { class: "filter-item", clearable: "", modelValue: o.wastageRate, "onUpdate:modelValue": (q) => o.wastageRate = q, placeholder: "请输入损耗系数", style: { width: "100%" }, onInput: (q) => se(q, o, h) }, null, 8, ["modelValue", "onUpdate:modelValue", "onInput"])]), _: 1 }), l(c, { key: "length", prop: "length", label: "领料长度(m)", align: "center" }, { default: s(({ row: o }) => [z("span", null, P(parseFloat((o.length / 1e3 * o.wastageRate).toFixed(3))), 1)]), _: 1 }), l(c, { label: "库存", align: "center" }, { default: s(({ row: o }) => [l(a, { type: "primary", onClick: J((h) => ne(o), ["stop"]) }, { default: s(() => [l(Ke, { "icon-class": "eye-open" })]), _: 2 }, 1032, ["onClick"])]), _: 1 }), l(c, { "show-overflow-tooltip": true, label: "操作", width: "80", align: "center" }, { default: s(({ row: o }) => [l(a, { type: "danger", disabled: d.value, icon: "el-icon-delete", onClick: J((h) => ue(o, o.id), ["stop"]) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]), l(at, { visible: G.value, "onUpdate:visible": e[4] || (e[4] = (o) => G.value = o), list: p.list, bindingWorkshopId: T.value, sureBinding: f.value, schedulingGroups: y.value, onSuccess: ge }, null, 8, ["visible", "list", "bindingWorkshopId", "sureBinding", "schedulingGroups"]), l(lt, { visible: $.value, "onUpdate:visible": e[5] || (e[5] = (o) => $.value = o), bindingWorkshopId: T.value, schedulingGroups: y.value, list: H.value }, null, 8, ["visible", "bindingWorkshopId", "schedulingGroups", "list"])], 64);
  };
} }, ht = We(st, [["__scopeId", "data-v-b57903a9"]]);
export {
  ht as default
};
