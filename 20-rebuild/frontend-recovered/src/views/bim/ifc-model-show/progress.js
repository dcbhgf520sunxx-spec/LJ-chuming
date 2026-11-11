export const stages = {
  production: { title: '生产状态', labels: ['未生产', '在制品', '生产完毕'], colors: [0xe5e9ee, 0xffba00, 0x1682e6], fields: ['inProduction', 'complete'] },
  shipment: { title: '发运状态', labels: ['未入库', '已入库', '已发运'], colors: [0xe5e9ee, 0xffba00, 0x1682e6], fields: ['inbound', 'outbound'] },
  installation: { title: '安装状态', labels: ['未收货', '已收货', '已安装'], colors: [0xe5e9ee, 0xffba00, 0x32d3a6], fields: ['received', 'installed'] },
};

export const selectionColor = 0xff2d78;

export function statusAppearance(stage, match) {
  if (!match || !stages[stage]) return {label: '暂无进度', color: 0x8796a9};
  if (match.state === 'mixed') return {
    label: match.count === match.quantity ? '部分完成' : '数量待核对', color: 0xa26de4,
  };
  return {label: stages[stage].labels[match.state], color: stages[stage].colors[match.state]};
}

export function isSelectedPart(item, selected) {
  if (!selected) return false;
  if (selected.elementOnly || selected.id && !selected.assemblyId) return item.id === selected.id;
  return selected.assemblyId ? item.assemblyId === selected.assemblyId : item.mark === selected.mark;
}

export function buildProgress(assemblies, rows, stage) {
  const instances = new Map();
  for (const { mark } of assemblies) {
    instances.set(mark, (instances.get(mark) || 0) + 1);
  }
  const totals = [0, 0, 0];
  const byMark = new Map();
  const weightTotals = [0, 0, 0];
  let hasWeights = false;
  let matched = 0;
  const [startedField, finishedField] = stages[stage].fields;
  for (const row of rows) {
    const count = instances.get(row.mark);
    if (!count) continue;
    const quantity = Number(row.quantity) || 0;
    const finished = Math.max(0, Math.min(quantity, Number(row[finishedField]) || 0));
    const started = Math.max(finished, Math.min(quantity, Number(row[startedField]) || 0));
    const amounts = [quantity - started, started - finished, finished];
    const state = count === quantity && amounts.includes(quantity) ? amounts.indexOf(quantity) : 'mixed';
    amounts.forEach((amount, index) => { totals[index] += amount; });
    const totalWeight = row.totalGrossWeight == null ? null : Number(row.totalGrossWeight);
    let weights = null;
    if (totalWeight != null && Number.isFinite(totalWeight)) {
      const perPiece = quantity ? totalWeight / quantity : 0;
      const finishedWeight = Math.max(0, Math.min(totalWeight, Number(row[finishedField + 'Weight'] ?? finished * perPiece)));
      const startedWeight = Math.max(finishedWeight, Math.min(totalWeight, Number(row[startedField + 'Weight'] ?? started * perPiece)));
      weights = [totalWeight - startedWeight, startedWeight - finishedWeight, finishedWeight];
      weights.forEach((amount, index) => { weightTotals[index] += amount; });
      hasWeights = true;
    }
    matched += count;
    byMark.set(row.mark, { quantity, amounts, state, count, weights, name: row.name });
  }
  return { totals, byMark, unmatched: assemblies.length - matched, weightTotals: hasWeights ? weightTotals : null };
}
